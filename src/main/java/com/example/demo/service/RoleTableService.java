package com.example.demo.service;

import com.example.demo.model.RoleTable;
import com.example.demo.mapper.RoleTableMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RoleTable)表服务实现类
 *
 * @author makejava
 * @since 2024-12-06 18:09:52
 */
@Service
public class RoleTableService implements RoleTableMapper {
    @Resource
    private RoleTableMapper roleTableMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 
     */
    @Override
    public RoleTable queryById(Integer roleId) {
        return this.roleTableMapper.queryById(roleId);
    }

    /**
     * 新增数据
     *
     * @param roleTable 实例对象
     * @return 
     */
    @Override
    public Integer insert(RoleTable roleTable) {
        return this.roleTableMapper.insert(roleTable);
    }

    /**
     * 修改数据
     *
     * @param roleTable 实例对象
     * @return
     */
    @Override
    public Integer update(RoleTable roleTable) {
        this.roleTableMapper.update(roleTable);
        return roleTable.getRoleId();
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer roleId) {
        Integer res = this.roleTableMapper.deleteById(roleId);
        return res;
    }

    @Override
    public RoleTable queryByRoleName(String roleName){
    	return this.roleTableMapper.queryByRoleName(roleName);
    }
}
