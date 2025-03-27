package com.example.demo.controller;

import com.example.demo.model.DownloadRecords;
import com.example.demo.service.DownloadRecordsService;
import com.example.demo.utils.JSONResult;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (DownloadRecords)表控制层
 *
 * @author makejava
 * @since 2024-12-12 15:59:10
 */
@RestController
@RequestMapping("downloadRecords")
public class DownloadRecordsController {
    /**
     * 服务对象
     */
    @Resource
    private DownloadRecordsService downloadRecordsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/id")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        DownloadRecords res = this.downloadRecordsService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param downloadRecords 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody DownloadRecords downloadRecords) {
        Integer res = this.downloadRecordsService.insert(downloadRecords);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param downloadRecords 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody DownloadRecords downloadRecords) {
        Integer res = this.downloadRecordsService.update(downloadRecords);
        String msg = "数据编辑成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/id")
    public ResponseEntity<JSONResult> deleteById(@Param("id")Integer id) {
        Integer res = this.downloadRecordsService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 查询所有行数据
     * @return 所有行数据
     */
    @GetMapping("/queryAll")
    public ResponseEntity<JSONResult> queryAll() {
        List<DownloadRecords> res = this.downloadRecordsService.queryAll();
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }
    
    /**
     *
     * 分页查询所有行数据
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return 所有行数据
     */
    @GetMapping("/queryAllWithPagination")
    public ResponseEntity<JSONResult> queryAllWithPagination(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<DownloadRecords> res = this.downloadRecordsService.queryAllWithPagination(pageNum, pageSize);
        String msg = "分页查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }
    
    
}
