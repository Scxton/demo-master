package com.example.demo.mapper;

import com.example.demo.model.InteractionEvaluation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (InteractionEvaluation)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-12 15:59:55
 */
public interface InteractionEvaluationMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param interactionId 主键
     * @return 实例对象
     */
    InteractionEvaluation queryById(Integer interactionId);

    /**
     * 新增数据
     *
     * @param interactionEvaluation 实例对象
     * @return 影响行数
     */
    Integer insert(InteractionEvaluation interactionEvaluation);

    /**
     * 修改数据
     *
     * @param interactionEvaluation 实例对象
     * @return 影响行数
     */
    Integer update(InteractionEvaluation interactionEvaluation);

    /**
     * 通过主键删除数据
     *
     * @param interactionId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer interactionId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<InteractionEvaluation> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<InteractionEvaluation> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

     List<InteractionEvaluation> querylimitWithPagination (InteractionEvaluation interactionEvaluation, @Param("offset") int offset , @Param("limit") int limit);
}

