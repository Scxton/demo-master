package com.example.demo.service;

import com.example.demo.mapper.FileRecordMapper;
import com.example.demo.model.FileRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FileRecord)表服务实现类
 *
 * @author makejava
 * @since 2024-12-12 15:58:28
 */
@Service
public class FileRecordService implements FileRecordMapper {
    @Resource
    private FileRecordMapper fileRecordMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 
     */
    @Override
    public FileRecord queryById(Integer fileId) {
        return this.fileRecordMapper.queryById(fileId);
    }

    /**
     * 新增数据
     *
     * @param fileRecord 实例对象
     * @return 
     */
    @Override
    public Integer insert(FileRecord fileRecord) {
        return this.fileRecordMapper.insert(fileRecord);
    }

    /**
     * 修改数据
     *
     * @param fileRecord 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(FileRecord fileRecord) {
        this.fileRecordMapper.update(fileRecord);
        return fileRecord.getFileId();
    }

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer fileId) {
        Integer res = this.fileRecordMapper.deleteById(fileId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<FileRecord> queryAll(){
        return this.fileRecordMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<FileRecord> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.fileRecordMapper.queryAllWithPagination(offset,pageSize);
        
     }
     @Override
    public List<FileRecord> queryAllByLimit(FileRecord fileRecord) {

        
        return this.fileRecordMapper.queryAllByLimit(fileRecord);
    }
}
