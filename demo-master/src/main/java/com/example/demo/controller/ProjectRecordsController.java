package com.example.demo.controller;
import com.example.demo.service.ProjectRecordsService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import com.example.demo.model.ProjectRecords;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectRecords)表控制层
 *
 * @author makejava
 * @since 2025-03-21 13:43:54
 */
@RestController
@RequestMapping("projectRecords")
public class ProjectRecordsController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectRecordsService projectRecordsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        ProjectRecords res = this.projectRecordsService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param projectRecords 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody ProjectRecords projectRecords) {
        Integer res = this.projectRecordsService.insert(projectRecords);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param projectRecords 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody ProjectRecords projectRecords) {
        Integer res = this.projectRecordsService.update(projectRecords);
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
        Integer res = this.projectRecordsService.deleteById(id);
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
        List<ProjectRecords> res = this.projectRecordsService.queryAll();
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
        List<ProjectRecords> res = this.projectRecordsService.queryAllWithPagination(pageNum, pageSize);
        String msg = "分页查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 根据机构id查询项目数量
     * @param organizationId 机构id
     * @return 项目数量
     */
    @GetMapping("/countProjectsByOrganizationId")
    public ResponseEntity<JSONResult> countProjectsByOrganizationId(@RequestParam(value = "organizationId") Integer organizationId) {
        Integer res = this.projectRecordsService.countProjectsByOrganizationId(organizationId);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 根据机构id查询成果数量
     * @param organizationId 机构id
     * @return 成果数量
     */
    @GetMapping("/countAchievementsByOrganizationId")
    public ResponseEntity<JSONResult> countAchievementsByOrganizationId(@RequestParam(value = "organizationId") Integer organizationId) {
        Integer res = this.projectRecordsService.countAchievementsByOrganizationId(organizationId);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }
}
