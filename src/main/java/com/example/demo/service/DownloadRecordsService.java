package com.example.demo.service;

import com.example.demo.mapper.DownloadRecordsMapper;
import com.example.demo.model.DownloadRecords;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DownloadRecords)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 15:59:10
 */
@Service
public class DownloadRecordsService implements DownloadRecordsMapper {
    @Resource
    private DownloadRecordsMapper downloadRecordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param downloadId 主键
     * @return 
     */
    @Override
    public DownloadRecords queryById(Integer downloadId) {
        return this.downloadRecordsMapper.queryById(downloadId);
    }

    /**
     * 新增数据
     *
     * @param downloadRecords 实例对象
     * @return 
     */
    @Override
    public Integer insert(DownloadRecords downloadRecords) {
        return this.downloadRecordsMapper.insert(downloadRecords);
    }

    /**
     * 修改数据
     *
     * @param downloadRecords 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(DownloadRecords downloadRecords) {
        this.downloadRecordsMapper.update(downloadRecords);
        return downloadRecords.getDownloadId();
    }

    /**
     * 通过主键删除数据
     *
     * @param downloadId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer downloadId) {
        Integer res = this.downloadRecordsMapper.deleteById(downloadId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<DownloadRecords> queryAll(){
        return this.downloadRecordsMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<DownloadRecords> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.downloadRecordsMapper.queryAllWithPagination(offset,pageSize);
        
     }
}
