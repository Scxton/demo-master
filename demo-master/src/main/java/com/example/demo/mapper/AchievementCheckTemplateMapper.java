package com.example.demo.mapper;

import com.example.demo.model.AchievementCheckTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AchievementCheckTemplate)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-10 14:52:10
 */
public interface AchievementCheckTemplateMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param templateId 主键
     * @return 实例对象
     */
    AchievementCheckTemplate queryById(Integer templateId);

    /**
     * 新增数据
     *
     * @param achievementCheckTemplate 实例对象
     * @return 影响行数
     */
    Integer insert(AchievementCheckTemplate achievementCheckTemplate);

    /**
     * 修改数据
     *
     * @param achievementCheckTemplate 实例对象
     * @return 影响行数
     */
    Integer update(AchievementCheckTemplate achievementCheckTemplate);

    /**
     * 通过主键删除数据
     *
     * @param templateId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer templateId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<AchievementCheckTemplate> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<AchievementCheckTemplate> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

}

