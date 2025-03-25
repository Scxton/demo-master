package com.example.demo.controller;

import com.example.demo.model.AchievementTable;
import com.example.demo.model.SearchBody;
import com.example.demo.service.AchievementTableService;
import com.example.demo.utils.JSONResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.util.List;

/**
 * (AchievementTable)表控制层
 *
 * @author makejava
 * @since 2024-12-11 10:50:06
 */
@RestController
@Slf4j
@RequestMapping("achievementTable")
public class AchievementTableController {
    /**
     * 服务对象
     */
    @Resource
    private AchievementTableService achievementTableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<JSONResult> queryById(@Param("id") Integer id) {
        AchievementTable res = this.achievementTableService.queryById(id);
        String msg = "查询成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 新增数据
     *
     * @param achievementTable 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<JSONResult> add(@RequestBody AchievementTable achievementTable) {
        Integer res = this.achievementTableService.insert(achievementTable);
        String msg = "数据插入成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 编辑数据
     *
     * @param achievementTable 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    @PreAuthorize("hasAuthority('ROLE_1')")
    public ResponseEntity<JSONResult> edit(@RequestBody AchievementTable achievementTable) {
        log.info("edit achievementTable");
        Integer res = this.achievementTableService.update(achievementTable);
        String msg = "数据编辑成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
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
    public ResponseEntity<JSONResult> deleteById(@Param("id")Integer id) {
        Integer res = this.achievementTableService.deleteById(id);
        String msg = "数据删除成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAll")
    public ResponseEntity<JSONResult> queryAll() {
        List<AchievementTable> res = this.achievementTableService.queryAll();
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 查询数据条数
     *
     * @return 所有数据条数
     */
    @GetMapping("/countAchievements")
    public ResponseEntity<JSONResult> countAchievements() {
        Integer res = this.achievementTableService.countAchievements();
        String msg = "查询所有行数成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAllWithPagination")
    public ResponseEntity<JSONResult> queryAllWithPagination(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryAllWithPagination(pageNum, pageSize);
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页查询专利数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAllWithPatent")
    public ResponseEntity<JSONResult> queryAllWithPatent(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryAllWithPatent(pageNum, pageSize);
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页查询论文数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAllWithPaper")
    public ResponseEntity<JSONResult> queryAllWithPaper(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryAllWithPaper(pageNum, pageSize);
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页查询其他成果数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAllWithOthers")
    public ResponseEntity<JSONResult> queryAllWithOthers(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryAllWithOthers(pageNum, pageSize);
        String msg = "查询所有行成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页查询待审核成果数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryAllWithPaginationForApproval")
    public ResponseEntity<JSONResult> queryAllWithPaginationForApproval(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryAllWithPaginationForApproval(pageNum, pageSize);
        String msg = "查询待审核数据成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页模糊查询待审核成果数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryByLikeApproval")
    public ResponseEntity<JSONResult> queryByLikeApproval(@RequestParam String achievementName,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryByLikeApproval(achievementName, pageNum, pageSize);
        String msg = "模糊搜索待审核数据成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 分页模糊查询所有成果数据
     *
     * @return 所有数据
     */
    @GetMapping("/queryByLike")
    public ResponseEntity<JSONResult> queryByLike(@RequestParam String achievementName,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        List<AchievementTable> res = this.achievementTableService.queryByLike(achievementName, pageNum, pageSize);
        String msg = "模糊搜索数据成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
        }

    //恢复单条删除数据
    @PostMapping("/restoreById")
    //@PreAuthorize("hasAuthority('ROLE_1')")
    public ResponseEntity<JSONResult> restoreById(@Param("id")Integer id) {
        Integer res = this.achievementTableService.restoreById(id);
        String msg = "数据恢复成功";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    //恢复所有删除的数据
    @PostMapping ("/restoreAll")
    @PreAuthorize("hasAuthority('ROLE_1')")
    public ResponseEntity<JSONResult> restoreAll() {
        Integer res = this.achievementTableService.restoreAll();
        String msg = "数据已一键恢复成功!";
        int statusCode = HttpStatus.OK.value();
        JSONResult jsonResult = new JSONResult("success",statusCode,msg,res);
        return ResponseEntity.ok(jsonResult);
    }

    /**
     * 模糊条件查询
     * @param searchBody 实体
     * @return 模糊条件查询结果
     */
    @SuppressWarnings("unused")
    @PostMapping("/fuzzyQuery")
    public ResponseEntity<JSONResult> fuzzyQuery(
            @RequestBody SearchBody searchBody
    ){
        log.info("fuzzyQuery");
//        log.info("keywords:{}", searchBody.getKeywords());
//        log.info("subject:{}", searchBody.getSubjectCategorys());
//        log.info("technology:{}",searchBody.getTechnologyCategorys());
        log.info("searchBody:{}",searchBody.getAchievementBelongingOrganizations());
        Integer pageNum = searchBody.getPageNum();
        Integer pageSize = searchBody.getPageSize();
        if(pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        JSONResult jsonResult = new JSONResult();
        List<AchievementTable> result;
        int statusCode = HttpStatus.OK.value();
        jsonResult.setResultCode(statusCode);
        jsonResult.setResultMsg("关键词搜索");
        if (searchBody != null) {
            // 调用服务层的多关键词模糊查询
            result = achievementTableService.fuzzyQuery(searchBody, pageNum, pageSize);
            if (result != null && !result.isEmpty()) {
                for (AchievementTable achievementTable : result) {
                    achievementTable.setSearchCount(achievementTable.getSearchCount() + 1);
                    achievementTableService.update(achievementTable);
                }
                jsonResult.setType("success");
                jsonResult.setData(result);
            } else {
                jsonResult.setType("fail");
                jsonResult.setResultMsg("没有找到匹配的成果");
            }
        } else {
            jsonResult.setType("fail");
            jsonResult.setResultMsg("没有提供有效的关键词");
        }

        return ResponseEntity.ok(jsonResult);
    }

}
