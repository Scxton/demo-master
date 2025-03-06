package com.example.demo.controller;

import com.example.demo.model.AchievementCheckTemplate;
import com.example.demo.service.AchievementCheckTemplateService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * (AchievementCheckTemplate)表控制层
 *
 * @author makejava
 * @since 2024-12-10 15:53:41
 */
@RestController
@RequestMapping("achievementCheckTemplate")
public class AchievementCheckTemplateController {
    /**
     * 服务对象
     */
    @Resource
    private AchievementCheckTemplateService achievementCheckTemplateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        AchievementCheckTemplate res = this.achievementCheckTemplateService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param achievementCheckTemplate 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody AchievementCheckTemplate achievementCheckTemplate) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        achievementCheckTemplate.setUploadTime(now.format(formatter2));
        Integer res = this.achievementCheckTemplateService.insert(achievementCheckTemplate);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param achievementCheckTemplate 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody AchievementCheckTemplate achievementCheckTemplate) {
        Integer  res = this.achievementCheckTemplateService.update(achievementCheckTemplate);
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
        Integer res = this.achievementCheckTemplateService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAll")
    public ResponseEntity<JSONResult> queryAll() {
        List<AchievementCheckTemplate> res = this.achievementCheckTemplateService.queryAll();
        String msg = "获取所有模板成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    @GetMapping("/queryAllWithPagination")
    public ResponseEntity<JSONResult> queryAllWithPagination(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementCheckTemplate> res = this.achievementCheckTemplateService.queryAllWithPagination(pageNum, pageSize);
        String msg = "获取所有模板成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult= new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }
}
