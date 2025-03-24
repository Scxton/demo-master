package com.example.demo.service;

import com.example.demo.model.ApprovalGet;
import com.example.demo.model.ApprovalRecords;
import com.example.demo.mapper.ApprovalRecordsMapper;
import com.example.demo.service.ApprovalRecordsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ApprovalRecords)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 16:08:04
 */
@Service
public class ApprovalRecordsService implements ApprovalRecordsMapper {
    @Resource
    private ApprovalRecordsMapper approvalRecordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param approvalId 主键
     * @return
     */
    @Override
    public ApprovalRecords queryById(Integer approvalId) {
        return this.approvalRecordsMapper.queryById(approvalId);
    }

    /**
     * 新增数据
     *
     * @param approvalRecords 实例对象
     * @return
     */
    @Override
    public Integer insert(ApprovalRecords approvalRecords) {
        return this.approvalRecordsMapper.insert(approvalRecords);
    }

    /**
     * 修改数据
     *
     * @param approvalRecords 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(ApprovalRecords approvalRecords) {
        this.approvalRecordsMapper.update(approvalRecords);
        return approvalRecords.getApprovalId();
    }

    /**
     * 通过主键删除数据
     *
     * @param approvalId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer approvalId) {
        Integer res = this.approvalRecordsMapper.deleteById(approvalId);
        return res;
    }

    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
    @Override
    public List<ApprovalRecords> queryAll(){
        return this.approvalRecordsMapper.queryAll();
    }

    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
    @Override
    public List<ApprovalRecords> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.approvalRecordsMapper.queryAllWithPagination(offset,pageSize);
    }

    /**
     * 分页查询待审批所有行数据
     *
     * @return 表中待审批的所有行数据
     *
     */
    @Override
    public List<ApprovalGet> queryAllWithPaginationForApproval(int pageNum, int pageSize, int flag){
        int offset = (pageNum - 1) * pageSize ;
        return this.approvalRecordsMapper.queryAllWithPaginationForApproval(offset,pageSize,flag);
    }

    /**
     * 审批通过
     *
     * @return 是否成功
     */
    @Override
    public Integer approvalTrue(ApprovalRecords approvalRecords){
        return this.approvalRecordsMapper.approvalTrue(approvalRecords);
    }
}
