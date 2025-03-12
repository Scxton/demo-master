package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import java.util.List;
import com.example.demo.model.PatentComplaints;
//import com.example.demo.model.PatentComplaints.ComplaintProcessStatus;

public interface PatentComplaintsMapper {

    //通过投诉id查询投诉信息
    PatentComplaints findById(Integer complaintId);

    //通过用户id查询投诉信息
    PatentComplaints queryByuserId(Integer userId);

    Integer insertComplaint(PatentComplaints patentComplaints);

    Integer updateComplaint(PatentComplaints patentComplaints);

    Integer deleteByuserId(Integer userId);

    Integer deleteById(Integer complaintId);

    List<PatentComplaints> queryAll();

    //更改审核状态
    Integer updateComplaintStatus(Integer complaintId, Integer complaintProcess);

//    Boolean updateStatusToInProgress(Integer complaintId);
//
//    Boolean updateStatusToAccepted(Integer complaintId);

}
