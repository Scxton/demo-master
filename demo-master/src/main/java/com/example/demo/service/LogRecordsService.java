package com.example.demo.service;

import com.example.demo.model.LogRecords;
import com.example.demo.mapper.LogRecordsMapper;
import com.example.demo.service.LogRecordsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (LogRecords)表服务实现类
 *
 * @author makejava
 * @since 2024-12-09 14:50:56
 */
@Service
public class LogRecordsService implements LogRecordsMapper {
    @Resource
    private LogRecordsMapper logRecordsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param logId 主键
     * @return 
     */
    @Override
    public LogRecords queryById(Integer logId) {
        return this.logRecordsMapper.queryById(logId);
    }

    /**
     * 新增数据
     *
     * @param logRecords 实例对象
     * @return 
     */
    @Override
    public Integer insert(LogRecords logRecords) {
        return this.logRecordsMapper.insert(logRecords);
    }

    /**
     * 修改数据
     *
     * @param logRecords 实例对象
     * @return 
     */
    @Override
    public Integer update(LogRecords logRecords) {
        this.logRecordsMapper.update(logRecords);
        return logRecords.getLogId();
    }

    /**
     * 通过主键删除数据
     *
     * @param logId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer logId) {
        Integer res = this.logRecordsMapper.deleteById(logId);
        return res;
    }
}
