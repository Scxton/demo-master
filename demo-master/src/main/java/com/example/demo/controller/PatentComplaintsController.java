package com.example.demo.controller;
import com.example.demo.model.IntellectualProperty;
import com.example.demo.model.PatentComplaints;
import com.example.demo.service.IntellectualPropertyService;
import com.example.demo.service.PatentComplaintsService;
import com.example.demo.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("patentComplaints")
@Slf4j
public class PatentComplaintsController {

    @Resource
    private PatentComplaintsService patentComplaintsService;

    // 通过投诉信息id查询投诉信息
    @GetMapping("/findById")
    public ResponseEntity<JSONResult> findById(@Param("userId") Integer complaintId) {
        PatentComplaints res = this.patentComplaintsService.queryByuserId(complaintId);
        String msg = "投诉信息查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }


    // 通过用户id查询投诉信息
    @GetMapping("/queryByuserId")
    public ResponseEntity<JSONResult> queryById(@Param("userId") Integer userId) {
        PatentComplaints res = this.patentComplaintsService.queryByuserId(userId);
        String msg = "用户投诉查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    // 新增投诉信息
    @PostMapping("/insertComplaint")
    public ResponseEntity<JSONResult> insertComplaint(@RequestBody PatentComplaints patentComplaints) {
        log.info("insertComplaint");
        log.info("patentComplaints id: {}",patentComplaints.getintellectualPropertyId());
        log.info("patentComplaints info: {}",patentComplaints.getComplaintIntro());
        log.info("patentComplaints {}",patentComplaints.getComplaintProcess());
        Integer res = this.patentComplaintsService.insertComplaint(patentComplaints);
        String msg = "信息投诉成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    // 更新投诉信息
//    @PostMapping("/updateComplaint")
//    public ResponseEntity<JSONResult> updateComplaint(@Param("patentComplaints") PatentComplaints patentComplaints) {
//        Integer res = this.patentComplaintsService.updateComplaint(patentComplaints);
//        String msg = "更新投诉信息成功";
//        int statusCode = HttpStatus.OK.value();
//        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
//        return ResponseEntity.ok(jsonResult);
//    }


    //查询投诉详情，并将状态修改为 "受理中"
    @GetMapping("/complaintId")
    public ResponseEntity<JSONResult> updateStatusToInProgress(@Param("complaintId") Integer complaintId, @Param("status") Integer status) {
        PatentComplaints complaint = this.patentComplaintsService.findById(complaintId);
        if( status == 0 && complaint != null ){
//            this.patentComplaintsService.updateComplaintStatus(complaintId, 1);
            String msg = "投诉信息受理中...";
            int statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success",statusCode,msg, status);
            return ResponseEntity.ok(jsonResult);
        }
        return ResponseEntity.ok(JSONResult.error(1001, "投诉信息待受理！"));
    }

    //审核投诉，修改状态为 "已受理"
    @PostMapping("/accept/complaintId")
    public ResponseEntity<JSONResult> updateStatusToAccepted(@Param("complaintId") Integer complaintId, @Param("status") Integer status) {
        PatentComplaints complaint = this.patentComplaintsService.findById(complaintId);
        //PatentComplaints.ComplaintProcessStatus status = complaint.getComplaintProcess();
        if( status == 1 && complaint != null ){
//            this.patentComplaintsService.updateComplaintStatus(complaintId, status);
            String msg = "投诉处理成功，已受理...";
            int statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success",statusCode,msg, 1);
            return ResponseEntity.ok(jsonResult);
        }
        return ResponseEntity.ok(JSONResult.error(1002, "状态更新失败，可能已被处理！"));
    }

    // 通过投诉信息id删除投诉信息
    @GetMapping("/deleteById")
    public ResponseEntity<JSONResult> deleteById(@Param("complaintId") Integer complaintId) {
        Integer res = this.patentComplaintsService.deleteByuserId(complaintId);
        String msg = "投诉信息删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    // 通过用户id删除投诉信息
    @GetMapping("/deleteByuserId")
    public ResponseEntity<JSONResult> deleteByuserId(@Param("userId") Integer userId) {
        Integer res = this.patentComplaintsService.deleteByuserId(userId);
        String msg = "用户删除投诉信息成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    // 查询所有投诉信息
    @GetMapping("/queryAll")
    public ResponseEntity<JSONResult> queryAll() {
        log.info("queryAll");
        List<PatentComplaints> res = this.patentComplaintsService.queryAll();
        log.info("res:{}",res.size());

        String msg = "查询所有投诉信息成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }
}