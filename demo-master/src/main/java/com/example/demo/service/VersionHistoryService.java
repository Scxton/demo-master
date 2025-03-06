package com.example.demo.service;

import com.example.demo.mapper.VersionHistoryMapper;
import com.example.demo.model.VersionHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VersionHistory)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 16:00:23
 */
@Service
public class VersionHistoryService implements VersionHistoryMapper {
    @Resource
    private VersionHistoryMapper versionHistoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param versionId 主键
     * @return 
     */
    @Override
    public VersionHistory queryById(Integer versionId) {
        return this.versionHistoryMapper.queryById(versionId);
    }

    /**
     * 新增数据
     *
     * @param versionHistory 实例对象
     * @return 
     */
    @Override
    public Integer insert(VersionHistory versionHistory) {
        return this.versionHistoryMapper.insert(versionHistory);
    }

    /**
     * 修改数据
     *
     * @param versionHistory 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(VersionHistory versionHistory) {
        this.versionHistoryMapper.update(versionHistory);
        return versionHistory.getVersionId();
    }
 
    /**
     * 通过主键删除数据
     *
     * @param versionId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer versionId) {
        Integer res = this.versionHistoryMapper.deleteById(versionId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<VersionHistory> queryAll(){
        return this.versionHistoryMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<VersionHistory> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.versionHistoryMapper.queryAllWithPagination(offset,pageSize);
        
     }

     @Override
     public List<VersionHistory> querylimitWithPagination(VersionHistory versionHistory, int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.versionHistoryMapper.querylimitWithPagination(versionHistory, offset,pageSize);
        
     }
}
