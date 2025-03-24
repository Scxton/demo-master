package com.example.demo.controller;

import com.example.demo.model.OrganizationInfo;
import com.example.demo.service.OrganizationInfoService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.util.List;

/**
 * (OrganizationInfo)表控制层
 *
 * @author makejava
 * @since 2024-12-11 15:56:07
 */
@RestController
@Slf4j
@RequestMapping("organizationInfo")
public class OrganizationInfoController {
    /**
     * 服务对象
     */
    @Resource
    private OrganizationInfoService organizationInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        log.info("queryById:{}", id);
        OrganizationInfo res = this.organizationInfoService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param organizationInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody OrganizationInfo organizationInfo) {
        log.info("add:{}", organizationInfo.getOrganizationName());
        log.info("add:{}", organizationInfo);
        Integer res = this.organizationInfoService.insert(organizationInfo);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param organizationInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody OrganizationInfo organizationInfo) {
        log.info("edit:{}", organizationInfo.getOrganizationName());
        int res = this.organizationInfoService.update(organizationInfo);
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
    public ResponseEntity<JSONResult> deleteById(@Param("id")Integer id) {
        log.info("deleteById:{}", id);
        Integer res = this.organizationInfoService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }


    @GetMapping("/queryAll")
    public ResponseEntity<JSONResult> queryAll() {
        log.info("queryAll");
        List<OrganizationInfo> res = this.organizationInfoService.queryAll();
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }
}
