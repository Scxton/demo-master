package com.example.demo.service;

import com.example.demo.mapper.ProjectRecordsMapper;
import com.example.demo.model.ProjectRecords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ProjectRecords)表服务实现类
 *
 * @author makejava
 * @since 2025-03-21 13:43:56
 */
@Service
public class ProjectRecordsService implements ProjectRecordsMapper {
    @Resource
    private ProjectRecordsMapper projectRecordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param projectId 主键
     * @return 
     */
    @Override
    public ProjectRecords queryById(Integer projectId) {
        return this.projectRecordsMapper.queryById(projectId);
    }

    /**
     * 新增数据
     *
     * @param projectRecords 实例对象
     * @return 
     */
    @Override
    public Integer insert(ProjectRecords projectRecords) {
        return this.projectRecordsMapper.insert(projectRecords);
    }

    /**
     * 修改数据
     *
     * @param projectRecords 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(ProjectRecords projectRecords) {
        this.projectRecordsMapper.update(projectRecords);
        return projectRecords.getProjectId();
    }

    /**
     * 通过主键删除数据
     *
     * @param projectId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer projectId) {
        Integer res = this.projectRecordsMapper.deleteById(projectId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<ProjectRecords> queryAll(){
        return this.projectRecordsMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<ProjectRecords> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.projectRecordsMapper.queryAllWithPagination(offset,pageSize);
        
     }

     /**
     * 根据机构ID查询项目数
     *
     * @return 项目数
     *
     */
     @Override
     public Integer countProjectsByOrganizationId(Integer organizationId){
         return this.projectRecordsMapper.countProjectsByOrganizationId(organizationId);
     }

     /**
     * 根据OrganizationId查询项目数
     *
     * @return 项目数
     *
     */
     @Override
     public Integer countAchievementsByOrganizationId(Integer achievementId){
         return this.projectRecordsMapper.countAchievementsByOrganizationId(achievementId);
     }
}
