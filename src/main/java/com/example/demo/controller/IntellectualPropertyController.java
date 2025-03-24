package com.example.demo.controller;

import com.example.demo.model.IntellectualProperty;
import com.example.demo.service.IntellectualPropertyService;
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
 * (IntellectualProperty)表控制层
 *
 * @author makejava
 * @since 2025-01-02 14:00:31
 */
@RestController
@RequestMapping("intellectualProperty")
public class IntellectualPropertyController {
    /**
     * 服务对象
     */
    @Resource
    private IntellectualPropertyService intellectualPropertyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        IntellectualProperty res = this.intellectualPropertyService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param intellectualProperty 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody IntellectualProperty intellectualProperty) {
        Integer res = this.intellectualPropertyService.insert(intellectualProperty);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param intellectualProperty 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody IntellectualProperty intellectualProperty) {
        Integer res = this.intellectualPropertyService.update(intellectualProperty);
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
        Integer res = this.intellectualPropertyService.deleteById(id);
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
        List<IntellectualProperty> res = this.intellectualPropertyService.queryAll();
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
        List<IntellectualProperty> res = this.intellectualPropertyService.queryAllWithPagination(pageNum, pageSize);
        String msg = "分页查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 模糊查询所有行数据
     * @param intellectualPropertyType 专利类型
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return 所有行数据
     */
    @GetMapping("/queryByLike")
    public ResponseEntity<JSONResult> queryByLike(@RequestParam String intellectualPropertyType,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<IntellectualProperty> res = this.intellectualPropertyService.queryByLike(intellectualPropertyType, pageNum, pageSize);
        String msg = "模糊查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 统计专利数量
     * @return 所有行数据
     */
    @GetMapping("/countIP")
    public ResponseEntity<JSONResult> countIP() {
        Integer res1 = this.intellectualPropertyService.countIntellectualProperties();
        Integer res2 = this.intellectualPropertyService.countActiveIntellectualProperties();
        String msg = "统计专利数量成功";
        int[] res = new int[2];
        res[0] = res1;
        res[1] = res2;
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 更新专利状态
     * @param expirationDate 专利过期时间
     * @param intellectualPropertyId 专利id
     * @return 更新结果
     */
    @PostMapping("/updateRenewalStatus")
    public ResponseEntity<JSONResult> updateRenewalStatus(@RequestParam String expirationDate,
                                                          @RequestParam Integer intellectualPropertyId) {
        Integer res = this.intellectualPropertyService.updateRenewalStatus(expirationDate, intellectualPropertyId);
        String msg = "更新成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    @GetMapping("/queryWait")
    public ResponseEntity<JSONResult> queryWait() {
        List<IntellectualProperty> res = this.intellectualPropertyService.queryWait();
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }


}
