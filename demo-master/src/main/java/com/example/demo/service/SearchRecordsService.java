package com.example.demo.service;

import com.example.demo.mapper.SearchRecordsMapper;
import com.example.demo.model.SearchRecords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SearchRecords)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 15:58:45
 */
@Service
public class SearchRecordsService implements SearchRecordsMapper {
    @Resource
    private SearchRecordsMapper searchRecordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param searchId 主键
     * @return 
     */
    @Override
    public SearchRecords queryById(Integer searchId) {
        return this.searchRecordsMapper.queryById(searchId);
    }

    /**
     * 新增数据
     *
     * @param searchRecords 实例对象
     * @return 
     */
    @Override
    public Integer insert(SearchRecords searchRecords) {
        return this.searchRecordsMapper.insert(searchRecords);
    }

    /**
     * 修改数据
     *
     * @param searchRecords 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(SearchRecords searchRecords) {
        this.searchRecordsMapper.update(searchRecords);
        return searchRecords.getSearchId();
    }

    /**
     * 通过主键删除数据
     *
     * @param searchId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer searchId) {
        Integer res = this.searchRecordsMapper.deleteById(searchId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<SearchRecords> queryAll(){
        return this.searchRecordsMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<SearchRecords> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.searchRecordsMapper.queryAllWithPagination(offset,pageSize);
        
     }
}
