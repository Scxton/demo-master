package com.example.demo.mapper;

import com.example.demo.model.ApprovalGet;
import com.example.demo.model.ApprovalRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ApprovalRecords)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 16:08:04
 */
public interface ApprovalRecordsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param approvalId 主键
     * @return 实例对象
     */
    ApprovalRecords queryById(Integer approvalId);

    /**
     * 新增数据
     *
     * @param approvalRecords 实例对象
     * @return 影响行数
     */
    Integer insert(ApprovalRecords approvalRecords);

    /**
     * 修改数据
     *
     * @param approvalRecords 实例对象
     * @return 影响行数
     */
    Integer update(ApprovalRecords approvalRecords);

    /**
     * 通过主键删除数据
     *
     * @param approvalId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer approvalId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<ApprovalRecords> queryAll();

    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
    List<ApprovalRecords> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

    /**
     *分页查询待审批所有行数据
     *
     *return 页中所有行数据
     *
     */
    List<ApprovalGet> queryAllWithPaginationForApproval(@Param("offset") int offset , @Param("limit") int limit, @Param("flag") int flag);

    /**
     * 审批是否通过
     *
     *return 影响行数
     *
     */
    Integer approvalTrue(ApprovalRecords approvalRecords);
}



