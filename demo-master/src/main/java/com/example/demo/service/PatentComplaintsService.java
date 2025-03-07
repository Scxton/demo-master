package com.example.demo.service;

import com.example.demo.model.PatentComplaints;

import java.util.List;
import com.example.demo.mapper.PatentComplaintsMapper;
import com.example.demo.mapper.UserRolePermissionsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//import com.example.demo.model.PatentComplaints.ComplaintProcessStatus;

import javax.annotation.Resource;

@Service
@Slf4j
public class PatentComplaintsService {

    @Resource
    private PatentComplaintsMapper patentComplaintsMapper;

    @Resource
    private UserRolePermissionsMapper userRolePermissionsMapper;

//    private ComplaintProcessStatus complaintProcessStatus;

    public PatentComplaints findById(Integer complaintId){
        return this.patentComplaintsMapper.findById(complaintId);
    }

    public PatentComplaints queryByuserId(Integer userId){
        return this.patentComplaintsMapper.queryByuserId(userId);
    }

    public Integer insertComplaint(PatentComplaints patentComplaints){
        return this.patentComplaintsMapper.insertComplaint(patentComplaints);
    }

    public Integer updateComplaint(PatentComplaints patentComplaints){
        return this.patentComplaintsMapper.updateComplaint(patentComplaints);
    }

    public Integer deleteByuserId(Integer userId){
        return this.patentComplaintsMapper.deleteByuserId(userId);
    }

    public List<PatentComplaints> queryAll(){
        return this.patentComplaintsMapper.queryAll();
    }

    //更改审核状态
//    public Integer updateComplaintStatus(Integer complaintId, Integer complaintStatus){
//        Integer status = complaintProcessStatus.getCode();
//        return this.patentComplaintsMapper.updateComplaintStatus(complaintId, status);
//    }


//     管理员查看投诉详情，修改状态为 "受理中"
//    public boolean updateStatusToInProgress(Integer complaintId) {
//        PatentComplaints complaint = patentComplaintsMapper.findById(complaintId);
//        if (complaint != null && complaint.getComplaintProcess() == 0) {
//            return patentComplaintsMapper.updateComplaintStatus(complaintId, 1) > 0;
//        }
//        return false;
//    }


//     管理员审核投诉，修改状态为 "已受理"
//    public boolean updateStatusToAccepted(Integer complaintId) {
//        PatentComplaints complaint = patentComplaintsMapper.findById(complaintId);
//        if (complaint != null && complaint.getComplaintProcess() == 1) {
//            return patentComplaintsMapper.updateComplaintStatus(complaintId, 2) > 0;
//        }
//        return false;
//    }
}
