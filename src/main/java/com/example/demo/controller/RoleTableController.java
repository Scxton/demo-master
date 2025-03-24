package com.example.demo.controller;

import com.example.demo.model.RoleTable;
import com.example.demo.service.RoleTableService;
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
 * (RoleTable)表控制层
 *
 * @author makejava
 * @since 2024-12-06 18:11:24
 */
@RestController
@RequestMapping("roleTable")
public class RoleTableController {
    /**
     * 服务对象
     */
    @Resource
    private RoleTableService roleTableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        RoleTable res = this.roleTableService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param roleTable 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody RoleTable roleTable) {
        Integer res = this.roleTableService.insert(roleTable);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param roleTable 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public ResponseEntity<JSONResult> edit(RoleTable roleTable) {
        int res = this.roleTableService.update(roleTable);
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
        Integer res = this.roleTableService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    @GetMapping("/queryByRoleName")
    public ResponseEntity<JSONResult> queryByRoleName(@Param("roleName") String roleName) {
        RoleTable res = this.roleTableService.queryByRoleName(roleName);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

}
