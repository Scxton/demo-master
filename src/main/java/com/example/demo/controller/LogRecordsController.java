package com.example.demo.controller;

import com.example.demo.model.LogRecords;
import com.example.demo.service.LogRecordsService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;

/**
 * (LogRecords)表控制层
 *
 * @author makejava
 * @since 2024-12-09 14:50:56
 */
@Slf4j
@RestController
@RequestMapping("logRecords")
public class LogRecordsController {
    /**
     * 服务对象
     */
    @Resource
    private LogRecordsService logRecordsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {

        LogRecords res = this.logRecordsService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param logRecords 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody LogRecords logRecords) {
        log.info("add LogRecords");
        log.info("logRecords: {}", logRecords.getUserId());
        log.info("logRecords: "+logRecords.getLogIntro());
        Integer res = this.logRecordsService.insert(logRecords);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param logRecords 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody LogRecords logRecords) {
        log.info("edit LogRecords");
        int res = this.logRecordsService.update(logRecords);
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
    @GetMapping("/delete")
    public ResponseEntity<JSONResult> deleteById(@Param("id") Integer id) {
        log.info("delete LogRecords");
        Integer res = this.logRecordsService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

}
