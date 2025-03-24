package com.example.demo.mapper;

import com.example.demo.model.DownloadRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DownloadRecords)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 15:59:10
 */
public interface DownloadRecordsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param downloadId 主键
     * @return 实例对象
     */
    DownloadRecords queryById(Integer downloadId);

    /**
     * 新增数据
     *
     * @param downloadRecords 实例对象
     * @return 影响行数
     */
    Integer insert(DownloadRecords downloadRecords);

    /**
     * 修改数据
     *
     * @param downloadRecords 实例对象
     * @return 影响行数
     */
    Integer update(DownloadRecords downloadRecords);

    /**
     * 通过主键删除数据
     *
     * @param downloadId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer downloadId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<DownloadRecords> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<DownloadRecords> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);
}

