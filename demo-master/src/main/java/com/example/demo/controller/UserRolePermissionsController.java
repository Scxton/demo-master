package com.example.demo.controller;

import com.example.demo.model.UserRolePermissions;
import com.example.demo.service.UserRolePermissionsService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (UserRolePermissions)表控制层
 *
 * @author makejava
 * @since 2024-12-13 16:26:59
 */
@RestController
@RequestMapping("userRolePermissions")
public class UserRolePermissionsController {
    /**
     * 服务对象
     */
    @Resource
    private UserRolePermissionsService userRolePermissionsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        UserRolePermissions res = this.userRolePermissionsService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param userRolePermissions 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_1')")
    public ResponseEntity<JSONResult> add(@RequestBody UserRolePermissions userRolePermissions) {
        // 密码加密
        userRolePermissions.setUserPwd(passwordEncoder.encode(userRolePermissions.getUserPwd()));
        Integer res = this.userRolePermissionsService.insert(userRolePermissions);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param userRolePermissions 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('ROLE_1')")
    public ResponseEntity<JSONResult> edit(@RequestBody UserRolePermissions userRolePermissions) {
        if (userRolePermissions.getUserPwd() != null) {
            // 密码加密
            userRolePermissions.setUserPwd(passwordEncoder.encode(userRolePermissions.getUserPwd()));
        }
        Integer res = this.userRolePermissionsService.update(userRolePermissions);
        String msg = "数据编辑成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_1')")
    public ResponseEntity<JSONResult> deleteById(@Param("id") Integer id) {
        Integer res = this.userRolePermissionsService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 查询所有行数据
     *
     * @return 所有行数据
     */
    @GetMapping("/queryAll")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<JSONResult> queryAll() {
        List<UserRolePermissions> res = this.userRolePermissionsService.queryAll();
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页查询所有行数据
     *
     * @param pageNum  页数
     * @param pageSize 页大小
     * @return 所有行数据
     */
    @GetMapping("/queryAllWithPagination")
    public ResponseEntity<JSONResult> queryAllWithPagination(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<UserRolePermissions> res = this.userRolePermissionsService.queryAllWithPagination(pageNum, pageSize);
        String msg = "分页查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 通过用户名查询用户并验证,登录验证
     *
     * @param userRolePermissions 用户名
     * @return 用户信息
     */
    @PostMapping("/checkByUserNameAndUserPwd")
    public ResponseEntity<JSONResult> checkByUserNameAndUserPwd(@RequestBody UserRolePermissions userRolePermissions) {
        UserRolePermissions res = this.userRolePermissionsService.checkByUserNameAndUserPwd(userRolePermissions.getUserName());
        if (res != null && Objects.equals(res.getUserPwd(), userRolePermissions.getUserPwd())) {
            String msg = "身份验证成功";
            int statusCode = HttpStatus.OK.value();
            JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
            return ResponseEntity.ok(jsonResult);
        }
        return ResponseEntity.ok(JSONResult.error(400, "用户名或密码错误"));
    }

    /**
     * 通过用户名模糊查询
     *
     * @return 用户信息
     */
    @GetMapping("/queryByLike")
    public ResponseEntity<JSONResult> queryByLike(@RequestParam String userName,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<UserRolePermissions> res = this.userRolePermissionsService.queryByLike(userName, pageNum, pageSize);
        String msg = "模糊查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success", statusCode, msg, res);
        return ResponseEntity.ok(jsonResult);
    }
}