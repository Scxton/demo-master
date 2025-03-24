package com.example.demo.mapper;

import com.example.demo.model.UserRolePermissions;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (UserRolePermissions)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-13 16:26:59
 */
public interface UserRolePermissionsMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserRolePermissions queryById(Integer userId);

    /**
     * 新增数据
     *
     * @param userRolePermissions 实例对象
     * @return 影响行数
     */
    Integer insert(UserRolePermissions userRolePermissions);

    /**
     * 修改数据
     *
     * @param userRolePermissions 实例对象
     * @return 影响行数
     */
    Integer update(UserRolePermissions userRolePermissions);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer userId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<UserRolePermissions> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<UserRolePermissions> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

     /**
      * 用户验证
      *
      *return 用户名和密码
      *
      */
     UserRolePermissions checkByUserNameAndUserPwd(@Param("userName") String userName);

     /**
      * 根据用户名查询用户
      *
      *return 用户
      *
      */
     UserRolePermissions findByUserName(@Param("userName") String userName);

     /**
      * 搜索框搜索
      *
      *return 匹配的数据
      *
      */
     UserRolePermissions getUserIdByUserName(@Param("userName") String userName);
     List<UserRolePermissions> queryByLike(@Param("userName") String userName, @Param("offset") int offset , @Param("limit") int limit);
}

