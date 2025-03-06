package com.example.demo.mapper;

import com.example.demo.model.VersionHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (VersionHistory)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 16:00:23
 */
public interface VersionHistoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param versionId 主键
     * @return 实例对象
     */
    VersionHistory queryById(Integer versionId);

    /**
     * 新增数据
     *
     * @param versionHistory 实例对象
     * @return 影响行数
     */
    Integer insert(VersionHistory versionHistory);

    /**
     * 修改数据
     *
     * @param versionHistory 实例对象
     * @return 影响行数
     */
    Integer update(VersionHistory versionHistory);

    /**
     * 通过主键删除数据
     *
     * @param versionId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer versionId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<VersionHistory> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<VersionHistory> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);
     /*
      * 条件分页查询
      */
     List<VersionHistory> querylimitWithPagination (VersionHistory versionHistory, @Param("offset") int offset , @Param("limit") int limit);
}

