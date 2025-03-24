package com.example.demo.service;

import com.example.demo.mapper.AchievementCheckTemplateMapper;
import com.example.demo.model.AchievementCheckTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AchievementCheckTemplate)表服务实现类
 *
 * @author makejava
 * @since 2024-12-10 14:52:10
 */
@Service
public class AchievementCheckTemplateService implements AchievementCheckTemplateMapper {
    @Resource
    private AchievementCheckTemplateMapper achievementCheckTemplateMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param templateId 主键
     * @return 
     */
    @Override
    public AchievementCheckTemplate queryById(Integer templateId) {
        return this.achievementCheckTemplateMapper.queryById(templateId);
    }

    /**
     * 新增数据
     *
     * @param achievementCheckTemplate 实例对象
     * @return 
     */
    @Override
    public Integer insert(AchievementCheckTemplate achievementCheckTemplate) {
        return this.achievementCheckTemplateMapper.insert(achievementCheckTemplate);
    }

    /**
     * 修改数据
     *
     * @param achievementCheckTemplate 实例对象
     * @return 
     */
    @Override
    public Integer update(AchievementCheckTemplate achievementCheckTemplate) {
        this.achievementCheckTemplateMapper.update(achievementCheckTemplate);
        return achievementCheckTemplate.getTemplateId();
    }

    /**
     * 通过主键删除数据
     *
     * @param templateId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer templateId) {
        Integer res = this.achievementCheckTemplateMapper.deleteById(templateId);
        return res;
    }

    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<AchievementCheckTemplate> queryAll(){
        return this.achievementCheckTemplateMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<AchievementCheckTemplate> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.achievementCheckTemplateMapper.queryAllWithPagination(offset,pageSize);
        
     }
}
