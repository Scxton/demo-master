package com.example.demo.mapper;

import com.example.demo.model.OrganizationInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (OrganizationInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-11 15:56:07
 */
public interface OrganizationInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param organizationId 主键
     * @return 实例对象
     */
    OrganizationInfo queryById(Integer organizationId);

    /**
     * 新增数据
     *
     * @param organizationInfo 实例对象
     * @return 影响行数
     */
    Integer insert(OrganizationInfo organizationInfo);

    /**
     * 修改数据
     *
     * @param organizationInfo 实例对象
     * @return 影响行数
     */
    Integer update(OrganizationInfo organizationInfo);

    /**
     * 通过主键删除数据
     *
     * @param organizationId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer organizationId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<OrganizationInfo> queryAll();
}

