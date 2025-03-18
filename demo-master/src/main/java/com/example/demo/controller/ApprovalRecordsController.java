package com.example.demo.controller;

import com.example.demo.model.ApprovalGet;
import com.example.demo.model.ApprovalRecords;
import com.example.demo.service.ApprovalRecordsService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (ApprovalRecords)表控制层
 *
 * @author makejava
 * @since 2024-12-12 16:08:04
 */
@RestController
@RequestMapping("approvalRecords")
public class ApprovalRecordsController {
    /**
     * 服务对象
     */
    @Resource
    private ApprovalRecordsService approvalRecordsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        ApprovalRecords res = this.approvalRecordsService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param approvalRecords 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody ApprovalRecords approvalRecords) {
        Integer res = this.approvalRecordsService.insert(approvalRecords);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param approvalRecords 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public ResponseEntity<JSONResult> edit(@RequestBody ApprovalRecords approvalRecords) {
        Integer res = this.approvalRecordsService.update(approvalRecords);
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
        Integer res = this.approvalRecordsService.deleteById(id);
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
        List<ApprovalRecords> res = this.approvalRecordsService.queryAll();
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
        List<ApprovalRecords> res = this.approvalRecordsService.queryAllWithPagination(pageNum, pageSize);
        String msg = "分页查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     *
     * 分页查询待审批数据表中的数据
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return 所有行数据
     * flag =0 未审批
     */
    @GetMapping("/queryAllWithPaginationForApproval")
    public ResponseEntity<JSONResult> queryAllWithPaginationForApproval(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                                                        @RequestParam(value = "flag", defaultValue = "0") int flag
    ) {
        List<ApprovalGet> res = this.approvalRecordsService.queryAllWithPaginationForApproval(pageNum, pageSize, flag);
        String msg = "分页查询待审批数据成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 审批或驳回
     * @param approvalRecords 审批记录
     * @return 审批结果
     */
    @PostMapping("/approvalTrue")
    public ResponseEntity<JSONResult> approvalTrue(@RequestBody ApprovalRecords approvalRecords) {
        Integer res = this.approvalRecordsService.approvalTrue(approvalRecords);
        int approvalStatus =approvalRecords.getApprovalStatus();
        String msg ;
        int statusCode;
        if(approvalStatus==1){
            msg = "审批通过";
            statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
            return ResponseEntity.ok(jsonResult);
        }
        msg = "审批驳回";
        statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("error",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

}
