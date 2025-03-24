package com.example.demo.service;

import com.example.demo.model.OrganizationInfo;
import com.example.demo.mapper.OrganizationInfoMapper;
import com.example.demo.service.OrganizationInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OrganizationInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-12-11 15:56:07
 */
@Service
public class OrganizationInfoService implements OrganizationInfoMapper {
    @Resource
    private OrganizationInfoMapper organizationInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param organizationId 主键
     * @return 
     */
    @Override
    public OrganizationInfo queryById(Integer organizationId) {
        return this.organizationInfoMapper.queryById(organizationId);
    }

    /**
     * 新增数据
     *
     * @param organizationInfo 实例对象
     * @return 
     */
    @Override
    public Integer insert(OrganizationInfo organizationInfo) {
        return this.organizationInfoMapper.insert(organizationInfo);
    }

    /**
     * 修改数据
     *
     * @param organizationInfo 实例对象
     * @return 
     */
    @Override
    public Integer update(OrganizationInfo organizationInfo) {
        this.organizationInfoMapper.update(organizationInfo);
        return organizationInfo.getOrganizationId();
    }

    /**
     * 通过主键删除数据
     *
     * @param organizationId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer organizationId) {
        Integer res = this.organizationInfoMapper.deleteById(organizationId);
        return res;
    }
    
    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
     @Override
     public List<OrganizationInfo> queryAll(){
        return this.organizationInfoMapper.queryAll();
     }
}
