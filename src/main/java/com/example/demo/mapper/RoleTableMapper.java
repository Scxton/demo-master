package com.example.demo.mapper;

import com.example.demo.model.RoleTable;

/**
 * (RoleTable)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-06 18:09:52
 */
public interface RoleTableMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    RoleTable queryById(Integer roleId);

    /**
     * 新增数据
     *
     * @param roleTable 实例对象
     * @return 影响行数
     */
    Integer insert(RoleTable roleTable);

    /**
     * 修改数据
     *
     * @param roleTable 实例对象
     * @return 影响行数
     */
    Integer update(RoleTable roleTable);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer roleId);

    RoleTable queryByRoleName(String roleName);

}

