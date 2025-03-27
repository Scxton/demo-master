package com.example.demo.mapper;


import com.example.demo.model.LogRecords;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import java.util.List;


/**
 * (LogRecords)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-09 14:50:56
 */
public interface LogRecordsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 实例对象
     */
    LogRecords queryById(Integer logId);

    /**
     * 新增数据
     *
     * @param logRecords 实例对象
     * @return 影响行数
     */
    Integer insert(LogRecords logRecords);

    /**
     * 修改数据
     *
     * @param logRecords 实例对象
     * @return 影响行数
     */
    Integer update(LogRecords logRecords);

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer logId);
    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<LogRecords> queryAll();

    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
    List<LogRecords> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

}

