package com.example.demo.service;

import com.alibaba.druid.sql.visitor.functions.Now;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.mapper.DataStatisticMapper;
import org.springframework.stereotype.Service;
import com.example.demo.utils.JSONResult;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import com.example.demo.model.DataStatistic;
import com.example.demo.mapper.UserRolePermissionsMapper;
import com.example.demo.model.UserRolePermissions;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;


@Slf4j
@Service
public class DataStatisticService {
    @Resource
    private DataStatisticMapper dataStatisticMapper;
    @Resource
    private UserRolePermissionsMapper userRolePermissionsMapper;


    public Integer userLoginInsert(Integer userId, String userName) {
        //   UserRolePermissions res = userRolePermissionsMapper.getUserIdByUserName(userName);
        //  Integer userId = res.getUserId();

        // 获取的 Date 对象（例如当前时间）
        Date logIn_Time = new Date();

        // 将 Date 转换为 yyyy-MM-dd HH:mm:ss 格式的字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedLogInTime = sdf.format(logIn_Time);
        log.info("1111111111");
        return this.dataStatisticMapper.userLoginInsert(userId, userName, formattedLogInTime, formattedLogInTime, null);
    }

//    @Override
//    public Integer userLogOutInsert(Integer userid, String userName) {
//        return null;
//    }

//    @Override
//    public Integer updateLogInTime(Integer userid, String userName) {
//        return null;
//    }

    public Integer updateLogOutInfo(String userName) {
        log.info("updateLogOutInfo");
        // UserRolePermissions res = userRolePermissionsMapper.getUserIdByUserName(userName);
        //  Integer userid = res.getUserId();
        // 获取的 Date 对象（例如当前时间）
        Date logOut_Time = new Date();

        // 将 Date 转换为 yyyy-MM-dd HH:mm:ss 格式的字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("1111111111");
        String formattedLogOutTime = sdf.format(logOut_Time);
        log.info("formattedLogOutTime " + formattedLogOutTime);
        String onlineDuration = onlineUserDuration(userName);
        log.info("onlineDuration " + onlineDuration);
        return this.dataStatisticMapper.updateLogOutInfo(userName, formattedLogOutTime, onlineDuration);
    }


    // 根据用户名获取用户的登录时间
    public String getLogInTimeByUsername(String userName) {
        log.info("getLogInTimeByUsername");
        log.info("userName " + userName);

        return this.dataStatisticMapper.getLogInTimeByUsername(userName);
    }

    // 计算当前用户的在线时长
    public String onlineUserDuration(String userName) {
        log.info("onlineUserDuration");
        String logInTime = getLogInTimeByUsername(userName);
        log.info("logInTime " + logInTime);


        //LocalTime time = logInTime
        // 将登录时间（字符串）解析为 LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime logIn_Time = LocalDateTime.parse(logInTime, formatter);

        LocalDateTime current_time = LocalDateTime.now();
        //log.info("current_time为：", current_time);
        Duration duration = Duration.between(logIn_Time, current_time);
        // 计算在线时长
        long seconds = duration.getSeconds();
        //log.info("在线时长为：", seconds);

        // 计算小时、分钟和秒
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;

        // 格式化为 HH:mm:ss 字符串
        String durationTime = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
        return durationTime;
    }

    public Integer countOnlineUser() {
        return this.dataStatisticMapper.countOnlineUser();
    }
}