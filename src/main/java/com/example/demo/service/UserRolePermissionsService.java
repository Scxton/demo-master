package com.example.demo.service;

import com.example.demo.model.UserRolePermissions;
import com.example.demo.mapper.UserRolePermissionsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserRolePermissions)表服务实现类
 *
 * @author makejava
 * @since 2024-12-13 16:26:59
 */
@Service
public class UserRolePermissionsService implements UserRolePermissionsMapper {
    @Resource
    private UserRolePermissionsMapper userRolePermissionsMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 查询对象
     */
    @Override
    public UserRolePermissions queryById(Integer userId) {
        return this.userRolePermissionsMapper.queryById(userId);
    }

    /**
     * 新增数据
     *
     * @param userRolePermissions 实例对象
     * @return 1
     */
    @Override
    public Integer insert(UserRolePermissions userRolePermissions) {
        return this.userRolePermissionsMapper.insert(userRolePermissions);
    }

    /**
     * 修改数据
     *
     * @param userRolePermissions 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(UserRolePermissions userRolePermissions) {
        this.userRolePermissionsMapper.update(userRolePermissions);
        return userRolePermissions.getUserId();
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer userId) {
        Integer res = this.userRolePermissionsMapper.deleteById(userId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<UserRolePermissions> queryAll(){
        return this.userRolePermissionsMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<UserRolePermissions> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.userRolePermissionsMapper.queryAllWithPagination(offset,pageSize);
     }

    /**
     * 登录用户验证
     *
     * @return 是否成功
     */
    @Override
    public UserRolePermissions checkByUserNameAndUserPwd(String userName) {
        return this.userRolePermissionsMapper.checkByUserNameAndUserPwd(userName);
    }

    public UserRolePermissions findByUserName(String userName) {
        return this.userRolePermissionsMapper.findByUserName(userName);
    }
    /**
     * 模糊查询
     *
     * @return 查询数据
     */
    @Override
    public List<UserRolePermissions> queryByLike(String userName, int pageNum , int pageSize){
        int offset = (pageNum - 1) * pageSize ;
    	return this.userRolePermissionsMapper.queryByLike(userName,offset,pageSize);
    }

    @Override
    public UserRolePermissions getUserIdByUserName(String userName){
        return this.userRolePermissionsMapper.getUserIdByUserName(userName);
    }

}
