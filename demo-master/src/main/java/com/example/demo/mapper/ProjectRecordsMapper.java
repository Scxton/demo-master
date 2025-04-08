package com.example.demo.mapper;

import com.example.demo.model.ProjectRecords;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ProjectRecords)表数据库访问层
 *
 * @author makejava
 * @since 2025-03-21 13:43:56
 */
public interface ProjectRecordsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param projectId 主键
     * @return 实例对象
     */
    ProjectRecords queryById(Integer projectId);

    /**
     * 新增数据
     *
     * @param projectRecords 实例对象
     * @return 影响行数
     */
    Integer insert(ProjectRecords projectRecords);

    /**
     * 修改数据
     *
     * @param projectRecords 实例对象
     * @return 影响行数
     */
    Integer update(ProjectRecords projectRecords);

    /**
     * 通过主键删除数据
     *
     * @param projectId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer projectId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<ProjectRecords> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<ProjectRecords> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

     /**
      *查询某单位总项目数
      *
      *return 总记录数
      *
      */
     Integer countProjectsByOrganizationId(Integer organizationId);

     /**
      *分页查询某单位成果
      *
      *return 页中所有行数据
      *
      */
     Integer countAchievementsByOrganizationId(Integer achievementId);
}

