package com.example.demo.service;

import com.example.demo.mapper.InteractionEvaluationMapper;
import com.example.demo.model.InteractionEvaluation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (InteractionEvaluation)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 15:59:55
 */
@Service
public class InteractionEvaluationService implements InteractionEvaluationMapper {
    @Resource
    private InteractionEvaluationMapper interactionEvaluationMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param interactionId 主键
     * @return 
     */
    @Override
    public InteractionEvaluation queryById(Integer interactionId) {
        return this.interactionEvaluationMapper.queryById(interactionId);
    }

    /**
     * 新增数据
     *
     * @param interactionEvaluation 实例对象
     * @return 
     */
    @Override
    public Integer insert(InteractionEvaluation interactionEvaluation) {
        return this.interactionEvaluationMapper.insert(interactionEvaluation);
    }

    /**
     * 修改数据
     *
     * @param interactionEvaluation 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(InteractionEvaluation interactionEvaluation) {
        this.interactionEvaluationMapper.update(interactionEvaluation);
        return interactionEvaluation.getInteractionId();
    }

    /**
     * 通过主键删除数据
     *
     * @param interactionId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer interactionId) {
        Integer res = this.interactionEvaluationMapper.deleteById(interactionId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<InteractionEvaluation> queryAll(){
        return this.interactionEvaluationMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<InteractionEvaluation> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.interactionEvaluationMapper.queryAllWithPagination(offset,pageSize);
     }
        
    @Override
    public List<InteractionEvaluation> querylimitWithPagination(InteractionEvaluation interactionEvaluation, int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.interactionEvaluationMapper.querylimitWithPagination(interactionEvaluation, offset,pageSize);
     }
}
