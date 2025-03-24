package com.example.demo.utils;

import com.example.demo.controller.FileController;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class FileTools {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    
        /**
         * 判断文件大小
         *
         * @param file  文件
         * @param size  限制大小
         * @param unit  限制单位（B,K,M,G）
         * @return
         */
        @SuppressWarnings("deprecation")
        public static boolean checkFileSize(MultipartFile file, int size, String unit) {
            if (file.isEmpty() || StringUtils.isEmpty(size) || StringUtils.isEmpty(unit)) {
                return false;
            }
            long len = file.getSize();
            double fileSize = 0;
            if ("B".equals(unit.toUpperCase())) {
                fileSize = (double) len;
            } else if ("K".equals(unit.toUpperCase())) {
                fileSize = (double) len / 1024;
            } else if ("M".equals(unit.toUpperCase())) {
                fileSize = (double) len / 1048576;
            } else if ("G".equals(unit.toUpperCase())) {
                fileSize = (double) len / 1073741824;
            }
            if (fileSize > size) {
                return false;
            }
            return true;
        }
        /*
         * 上传文件
         */
        @SuppressWarnings("null")
        public static JSONResult upload(MultipartFile file, String base_path, int num){
            String msg;
            String fileName = file.getOriginalFilename();
            JSONResult jsonResult = new JSONResult();
            int statusCode;
            try {
                statusCode = HttpStatus.OK.value();
                if (file.isEmpty()) {
                    msg = "第" + num + "个文件为空";
                    jsonResult = new JSONResult("fail", statusCode, msg, fileName);
                    return jsonResult;
                }
                long size = file.getSize();
                log.info("文件大小： " + size);
                if (!checkFileSize(file,200,"M")) {
                    log.error("上传文件规定小于200MB");
                    msg = "第" + num + "个文件超过限制大小200MB";
                    jsonResult = new JSONResult("fail", statusCode, msg, fileName);
                    return jsonResult;
                }
                log.info("上传的文件名为：" + fileName);
                // 获取文件的后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                log.info("文件的后缀名为：" + suffixName);
                // 设置文件存储路径
                String path = base_path + fileName;
                File dest = new File(path);
                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();// 新建文件夹
                }
                file.transferTo(dest);// 文件写入
                msg = "第" + num + "个文件上传成功";
                jsonResult = new JSONResult("success", statusCode, msg, fileName);
                return jsonResult;
            } catch (Exception e) {
                msg = "第" + num + "个文件上传失败";
                statusCode = HttpStatus.OK.value();
                e.printStackTrace();
                jsonResult = new JSONResult("fail", statusCode, msg, e.getMessage());
                return jsonResult;
            }
        }
        public static void forceDelete(File file) throws IOException {
            if (file.isDirectory()) {
                FileUtils.deleteDirectory(file);
            } else {
                boolean filePresent = file.exists();
                if (!file.delete()) {
                    if (!filePresent){
                        throw new FileNotFoundException("File does not exist: " + file);
                    }
                    String message =
                        "Unable to delete file: " + file;
                    throw new IOException(message);
                }
            }
        }

    public static void downloadfile(HttpServletResponse response, String basePath, String fileName) throws IOException{
            log.info("downloadfile");
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null; 
        File file = new File(basePath+fileName);
        FileSystemResource resource = new FileSystemResource(file);
        try {
            inputStream = resource.getInputStream();
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            FileCopyUtils.copy(bufferedInputStream, bufferedOutputStream);
            log.info("1111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null!=inputStream){
                inputStream.close();
            }
            if(null!=bufferedInputStream){
                bufferedInputStream.close();
            }
            if(null!=bufferedOutputStream){
            	bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
            log.info("22222222222");
        } 
    }
}
