package com.example.demo.mapper;
import com.example.demo.model.DataStatistic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
@Mapper
public interface DataStatisticMapper {

    // 用户登录时插入一条记录
    Integer userLoginInsert(@Param("userId") Integer userId, @Param("userName") String userName, @Param("logInTime") String logInTime, @Param("logOutTime") String logOutTime, @Param("duration") String duration);


    // 更新登出时长
    Integer updateLogOutInfo(@Param("userId") Integer userId, @Param("userName") String userName, @Param("logOutTime") String logOutTime, @Param("duration") String duration);

    // 获取当前用户在线时长
    Integer onlineUserDuration(@Param("userId") Integer userId, @Param("userName") String userName, @Param("logInTime") String logInTime, @Param("logOutTime") String logOutTime);
    // 获取最新的一条在线记录
    //Integer latestOnLineRecord(@Param("userId") Integer userId);

    //获取当前系统在线用户数量
    Integer countOnlineUser();

    String getLogInTimeByUsername(@Param("userName") String userName);

    // 获取用户下载次数
    //Integer getDownloadCount();
    //Integer updateDownloadCount();
    // 更新下载次数
    //Integer updateDownloadCount(@Param("userId") Integer userId, @Param("downloadCount") Integer downloadCount);
    // 获取用户登录时间
    //Date getLogInTime(@Param("userId") Integer userId, @Param("statisticId") Integer statisticId);
    //Integer getUserIdByUserName(@Param("userName") String userName);

}
