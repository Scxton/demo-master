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


    public Integer userLoginInsert(Integer userid, String userName) {
     //   UserRolePermissions res = userRolePermissionsMapper.getUserIdByUserName(userName);
      //  Integer userId = res.getUserId();

        // 获取的 Date 对象（例如当前时间）
        Date logIn_Time = new Date();

        // 将 Date 转换为 yyyy-MM-dd HH:mm:ss 格式的字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedLogInTime = sdf.format(logIn_Time);
        log.info("1111111111");
        return this.dataStatisticMapper.userLoginInsert(userid, userName, formattedLogInTime, formattedLogInTime, null);
    }

//    @Override
//    public Integer userLogOutInsert(Integer userid, String userName) {
//        return null;
//    }

//    @Override
//    public Integer updateLogInTime(Integer userid, String userName) {
//        return null;
//    }

    public Integer updateLogOutInfo(Integer userId, String userName) {
        UserRolePermissions res = userRolePermissionsMapper.getUserIdByUserName(userName);
        Integer userid = res.getUserId();
        // 获取的 Date 对象（例如当前时间）
        Date logOut_Time = new Date();

        // 将 Date 转换为 yyyy-MM-dd HH:mm:ss 格式的字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedLogOutTime = sdf.format(logOut_Time);
        String onlineDuration = onlineUserDuration(userName);
        return this.dataStatisticMapper.updateLogOutInfo(userid, userName, formattedLogOutTime, onlineDuration);
    }


    // 根据用户名获取用户的登录时间
    public String getLogInTimeByUsername(String userName)
    {
        return this.dataStatisticMapper.getLogInTimeByUsername(userName);
    }

    // 计算当前用户的在线时长
    public String onlineUserDuration(String userName)
    {
        String logInTime = getLogInTimeByUsername(userName);
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

    public Integer countOnlineUser(){
        return this.dataStatisticMapper.countOnlineUser();
    }

    // 用户登录
//    public void userLogin(Integer userId) {
//        // 插入一条登录记录
//
//        dataStatisticMapper.insertLogRecord(userId);
//    }
//
//    // 用户登出
//    public void userLogout(Integer userId) {
//        // 获取当前登录记录的 ID
//        Integer statisticId = dataStatisticMapper.latestOnLineRecord(userId);
//
//        // 计算登录时长
//        Date logOutTime = new Date(); // 获取当前时间作为登出时间
//        Date logInTime = dataStatisticMapper.getLogInTime(userId, statisticId); // 获取用户登录时间
//        long duration = (logOutTime.getTime() - logInTime.getTime()) / 1000; // 计算在线时长，单位为秒
//
//        // 更新登出时间和时长
//        dataStatisticMapper.updateLogOutInfo(userId, statisticId, (int) duration);
//    }

//     用户登出时更新登出时间和时长

//    private Integer getUserIdByUserName(String userName) {
//        // 假设你有一个方法根据用户名获取用户ID
//        // 这里可以根据实际情况从数据库或缓存中获取用户ID
//        return 1; // 假设返回ID为1的用户
//    }



//    @Override
//    public Integer userLoginInsert(String userName) {
//        // 获取用户ID，可以通过 userName 查找用户ID（如果你没有用户ID，可以通过用户名查询）
//        UserRolePermissions res;
//        res = userRolePermissionsMapper.getUserIdByUserName(userName);
//        //log.info("userid为：------", userId);
//        //Integer userId = userRolePermissionsMapper.getUserIdByUserName(userName);
//
//        Integer userId = res.getUserId();
//        String username = res.getUserName();
//        // 插入一条登录记录
//        // Integer statisticId = dataStatisticMapper.insertLogRecord(userId, userName);
//        //dataStatisticMapper.insertLogRecord(userId, userName);
//        // 更新登录时间，假设有 `logInTime` 字段
//        Date logInTime = new Date(); // 当前时间作为登录时间
//        Date logOutTime = new Date();
//        return dataStatisticMapper.userLoginInsert(userId);
//    }

//    @Override
//    public Integer userLogOutInsert(String userName) {
//        // 获取用户ID
//        UserRolePermissions res = userRolePermissionsMapper.getUserIdByUserName(userName);
//        Integer userId = res.getUserId();
////        Integer userId = userRolePermissionsMapper.getUserIdByUserName(userName);
//
//        // 获取登录记录的ID
//        Integer statisticId = dataStatisticMapper.latestOnLineRecord(userId);
//
//        // 获取登录时间
//        //Date logInTime = dataStatisticMapper.getLogInTime(userId, statisticId);
//        Date logInTime = new Date();
//        Date logOutTime = new Date();
//
//        // 计算在线时长（单位：秒）
//        long duration = (logOutTime.getTime() - logInTime.getTime()) / 1000;
//
//        // 更新登出时间和在线时长
//        dataStatisticMapper.updateLogOutInfo(userId, statisticId, (int) duration);
//    }



    // 获取用户下载次数（如果需要）
//    @Override
//    public Integer getDownloadCount() {
//        return dataStatisticMapper.getDownloadCount();
//    }

//    @Override
//    public Integer updateDownloadCount(Integer userId, Integer downloadCount) {
//        // 获取当前的下载次数
//        Integer currentDownloadCount = dataStatisticMapper.getDownloadCount();
//
//        // 增加下载次数
//        currentDownloadCount = currentDownloadCount != null ? currentDownloadCount + 1 : 1;
//
//        // 更新数据库中的下载次数
//        return dataStatisticMapper.updateDownloadCount(userId, currentDownloadCount);
//    }


    // 更新用户的登录时长
//    @Override
//    public void updateLoginDuration(Integer userId, Integer statisticId, Date logInTime) {
//        dataStatisticMapper.updateLogInTime(userId, statisticId, logInTime);
//    }


    //用户登录记录
//    public Integer insertLogInRecord(Integer userid){
//        return onlineDataMapper.insertLogInRecord(userid);
//    }
//    public Integer logOutRecord(Integer userid){
//        return onlineDataMapper.logOutRecord(userid);
//    }
    //用户退出记录
//    public void logOutUser(Integer userId) {
//        // 获取最新在线记录的记录ID
//        Integer recordId = onlineDataMapper.latestOnlineRecord(userId);
//        if (recordId != null) {
//            // 计算在线时长（假设用当前时间减去登录时间，单位为秒）
//            long loginTimeMillis = System.currentTimeMillis();
//            long duration = (System.currentTimeMillis() - loginTimeMillis) / 1000;
//
//            log.info("在线时长为：" + duration + "ms");
//
//            // 更新登出时间和时长
//            onlineDataMapper.updateLogOutInfo(recordId, (int) duration);
//        }
//
//    }

    // 用户登出
//    public JSONResult logOutUser(Integer userId) {
//        // 获取最新在线记录的记录ID
//        Integer recordId = onlineDataMapper.latestOnlineRecord(userId);
//        if (recordId != null) {
//            // 模拟计算在线时长（假设用当前时间减去登录时间，单位为秒）
//            long loginTimeMillis = System.currentTimeMillis(); // 模拟从数据库的 login_time
//            long duration = (System.currentTimeMillis() - loginTimeMillis) / 1000;
//
//            // 更新登出时间和时长
//            int rowsAffected = onlineDataMapper.updateLogOutInfo(recordId, (int) duration);
//
//            if (rowsAffected > 0) {
//                return JSONResult.ok("用户登出成功", null);
//            } else {
//                return JSONResult.error(500, "更新登出记录失败");
//            }
//        } else {
//            return JSONResult.error(404, "未找到用户在线记录");
//        }
//    }
    //统计在线人数
//    public  Integer countOnlineUser() {
//        return onlineDataMapper.countOnlineUser();
//    }


    // 更新用户在线时长
//    public void updateUserOnlineDuration(String username) {
//        // 在这里你可以根据用户名更新数据库中的在线时长记录
//        // 比如根据用户名查询用户的登录时间、登出时间，计算并保存在线时长
//    }
}
