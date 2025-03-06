package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DataBackupService {
//    public String backupKingbaseDatabase(String dbName, String backupPath, String dbHost, String dbUser, String dbPort) {
//        // 构造 kbsdump 命令
//        String command = String.format("kbsdump -h %s -U %s -p %s -d %s -F c -f %s",
//                dbHost, dbUser, dbPort, dbName, backupPath);
//
//        // 使用 ProcessBuilder 执行命令
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        processBuilder.command("bash", "-c", command);
//
//        try {
//            Process process = processBuilder.start();
//            int exitCode = process.waitFor();  // 等待命令执行完成
//
//            if (exitCode == 0) {
//                return "Backup successful! File saved at: " + backupPath;
//            } else {
//                return "Backup failed!";
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            return "Error during backup: " + e.getMessage();
//        }
//    }
// 定时任务：每月1号0点执行数据库备份
@Scheduled(cron = "0 0 0 1 * ?")  // cron 表达式：每月1号0点执行
public void backupDatabase() {
    String dbName = "your_database";  // 替换为你的数据库名
    String backupPath = "/path/to/backup/your_database_backup_" + System.currentTimeMillis() + ".sql";
    String dbHost = "localhost";
    String dbUser = "your_username";
    String dbPassword = "your_password";
    String dbPort = "54321";  // 例如人大金仓数据库端口

    // 执行备份操作
    String result = backupDatabaseCommand(dbName, backupPath, dbHost, dbUser, dbPassword, dbPort);
    System.out.println(result);  // 输出备份结果
}

    // 调用数据库备份命令
    private String backupDatabaseCommand(String dbName, String backupPath, String dbHost, String dbUser, String dbPassword, String dbPort) {
        String command = String.format("kbsdump -h %s -U %s -p %s -d %s -F c -f %s", dbHost, dbUser, dbPort, dbName, backupPath);
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", command);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();  // 等待命令执行完成
            if (exitCode == 0) {
                return "Backup successful! File saved at: " + backupPath;
            } else {
                return "Backup failed!";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error during backup: " + e.getMessage();
        }
    }
}
