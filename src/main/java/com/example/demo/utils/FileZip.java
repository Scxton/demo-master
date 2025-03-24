package com.example.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileZip {

    /**
     * 使用java.util.zip库进行文件压缩
     *
     * @param inputFile  要压缩的文件或目录
     * @param outputFile 压缩后的文件
     * @throws IOException 压缩过程中可能出现的异常
     */
    public static void zipCompress(File inputFile, File outputFile) throws IOException {
        // 创建输出流写入压缩后的文件
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFile))) {
            // 判断要压缩的是文件还是目录
            if (inputFile.isFile()) {
                // 压缩文件
                zipFile(inputFile, zos, "");
            } else if (inputFile.isDirectory()) {
                // 压缩目录
                zipDir(inputFile, zos, "");
            }
        }
    }

    /**
     * 递归压缩目录及其子目录和文件
     *
     * @param dir   要压缩的目录
     * @param zos   压缩输出流
     * @param entry 压缩实体
     * @throws IOException 压缩过程中可能出现的异常
     */
    private static void zipDir(File dir, ZipOutputStream zos, String entry) throws IOException {
        // 获取目录中的文件和子目录
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // 压缩文件
                    zipFile(file, zos, entry + file.getName());
                } else if (file.isDirectory()) {
                    // 压缩子目录
                    zipDir(file, zos, entry + file.getName() + "/");
                }
            }
        }
    }

    /**
     * 压缩文件
     *
     * @param file  要压缩的文件
     * @param zos   压缩输出流
     * @param entry 压缩实体
     * @throws IOException 压缩过程中可能出现的异常
     */
    private static void zipFile(File file, ZipOutputStream zos, String entry) throws IOException {
        // 创建压缩实体并设置实体名称
        ZipEntry zipEntry = new ZipEntry(entry);
        // 将压缩实体写入压缩输出流
        zos.putNextEntry(zipEntry);

        // 创建输入流读取文件内容，并将内容写入压缩输出流
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
        }

        // 关闭当前压缩实体
        zos.closeEntry();
    }

    /**
     * 使用java.util.zip库进行文件解压缩
     *
     * @param inputFile 压缩文件
     * @param outputDir 解压后的目录
     * @throws IOException 解压过程中可能出现的异常
     */
    public static void zipDecompress(File inputFile, File outputDir) throws IOException {
        // 创建输入流读取压缩文件
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(inputFile))) {
            // 遍历压缩文件中的实体
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                // 获取实体的名称
                String entryName = zipEntry.getName();
                // 创建输出文件并设置输出目录
                File outputFile = new File(outputDir, entryName);

                // 如果实体是目录，则创建相应目录；否则创建输出文件并写入数据
                if (zipEntry.isDirectory()) {
                    outputFile.mkdirs();
                } else {
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        // 将输入流的数据写入输出文件
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }

                // 关闭当前解压实体
                zis.closeEntry();
            }
        }
        
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input");
            File outputFile = new File("output.zip");
            File outputDir = new File("output");

            // 压缩文件或目录
            zipCompress(inputFile, outputFile);

            // 解压缩文件
            zipDecompress(outputFile, outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

