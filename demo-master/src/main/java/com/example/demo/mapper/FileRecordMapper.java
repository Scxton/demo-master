package com.example.demo.mapper;

import com.example.demo.model.FileRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (FileRecord)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 15:58:28
 */
public interface FileRecordMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    FileRecord queryById(Integer fileId);

    /**
     * 新增数据
     *
     * @param fileRecord 实例对象
     * @return 影响行数
     */
    Integer insert(FileRecord fileRecord);

    /**
     * 修改数据
     *
     * @param fileRecord 实例对象
     * @return 影响行数
     */
    Integer update(FileRecord fileRecord);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer fileId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<FileRecord> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<FileRecord> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);
     /*
     * 条件查询
     */
    List<FileRecord> queryAllByLimit(FileRecord fileRecord);
}

