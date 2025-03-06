package com.example.demo.mapper;

import com.example.demo.model.SearchRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (SearchRecords)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 15:58:45
 */
public interface SearchRecordsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param searchId 主键
     * @return 实例对象
     */
    SearchRecords queryById(Integer searchId);

    /**
     * 新增数据
     *
     * @param searchRecords 实例对象
     * @return 影响行数
     */
    Integer insert(SearchRecords searchRecords);

    /**
     * 修改数据
     *
     * @param searchRecords 实例对象
     * @return 影响行数
     */
    Integer update(SearchRecords searchRecords);

    /**
     * 通过主键删除数据
     *
     * @param searchId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer searchId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<SearchRecords> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<SearchRecords> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);
}

