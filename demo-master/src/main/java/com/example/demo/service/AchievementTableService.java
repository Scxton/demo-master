package com.example.demo.service;

import com.example.demo.model.AchievementTable;
import com.example.demo.mapper.AchievementTableMapper;
import com.example.demo.model.SearchBody;
import com.example.demo.service.AchievementTableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AchievementTable)表服务实现类
 *
 * @author makejava
 * @since 2024-12-11 10:50:06
 */
@Service
@Slf4j
public class AchievementTableService implements AchievementTableMapper {
    @Resource
    private AchievementTableMapper achievementTableMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param achievementId 主键
     * @return  对象
     */
    @Override
    public AchievementTable queryById(Integer achievementId) {
        return this.achievementTableMapper.queryById(achievementId);
    }

    /**
     * 新增数据
     *
     * @param achievementTable 实例对象
     * @return  1 插入成功
     */
    @Override
    public Integer insert(AchievementTable achievementTable) {
        return this.achievementTableMapper.insert(achievementTable);
    }

    /**
     * 修改数据
     *
     * @param achievementTable 实例对象
     * @return  1 修改成功
     */
    @Override
    public Integer update(AchievementTable achievementTable) {
        this.achievementTableMapper.update(achievementTable);
        return achievementTable.getAchievementId();
    }

    /**
     * 通过主键删除数据
     *
     * @param achievementId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer achievementId) {
        Integer res = this.achievementTableMapper.deleteById(achievementId);
        return res;
    }
    
    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
     @Override
     public List<AchievementTable> queryAll(){
        return this.achievementTableMapper.queryAll();
     }

     /**
     *统计行数
     *
     *return 表中行数
     *
     */
     @Override
     public Integer countAchievements() {
         return this.achievementTableMapper.countAchievements();
     }

     /**
     *分页查询所有行数据
     *
     *@param pageNum 查询起始位置
     *@param pageSize 查询条数
     *@return 表中所有行数据
     *
     */
     @Override
     public List<AchievementTable> queryAllWithPagination(int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryAllWithPagination(offset, pageSize);
     }

     /**
     *分页查询专利数据
     *
     *@param pageNum 查询起始位置
     *@param pageSize 查询条数
     *@return 表中所有行数据
     *
     */
     @Override
     public List<AchievementTable> queryAllWithPatent(int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryAllWithPatent(offset, pageSize);
     }

     /**
     *分页查询论文数据
     *
     *@param pageNum 查询起始位置
     *@param pageSize 查询条数
     *@return 表中所有行数据
     *
     */
     @Override
     public List<AchievementTable> queryAllWithPaper(int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryAllWithPaper(offset, pageSize);
     }

     /**
     *分页查询其他成果数据
     *
     *@param pageNum 查询起始位置
     *@param pageSize 查询条数
     *@return 分页对象
     *
     */
     @Override
     public List<AchievementTable> queryAllWithOthers(int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryAllWithOthers(offset, pageSize);
     }

     /**
     *分页查询待审核成果数据
     *
     *@param pageNum 查询起始位置
     *@param pageSize 查询条数
     *@return 分页对象
     *
     */
     @Override
     public List<AchievementTable> queryAllWithPaginationForApproval(int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryAllWithPaginationForApproval(offset, pageSize);
     }

     /**
     *分页模糊查询待审核成果数据
     *
     *@return 分页对象
     *
     */
     @Override
     public List<AchievementTable> queryByLikeApproval(String achievementName,int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryByLikeApproval(achievementName, offset, pageSize);
     }

     /**
     *分页模糊查询成果数据
     *
     *@return 分页对象
     *
     */
     @Override
     public List<AchievementTable> queryByLike(String achievementName, int pageNum, int pageSize) {
         int offset = (pageNum - 1) * pageSize;
         return this.achievementTableMapper.queryByLike(achievementName, offset, pageSize);
     }
    //通过主键恢复删除的数据
    @Override
    public Integer restoreById(Integer achievementId){
        Integer res = this.achievementTableMapper.restoreById(achievementId);
        return res;
    }
    //一键恢复所有被删除的数据
    @Override
    public Integer restoreAll(){
        Integer res = this.achievementTableMapper.restoreAll();
        return res;
    }

    /*
     * 精确查询条件数据
     */
    @Override
    public List<AchievementTable> queryAllByLimit(AchievementTable achievementTable) {


        return this.achievementTableMapper.queryAllByLimit(achievementTable);
    }
    /*
     * 精确查询条件数据
     */
    @Override
    public List<AchievementTable> fuzzyQuery(SearchBody searchBody, int pageNum, int pageSize) {
        log.info("service fuzzyQuery");
        log.info("searchBody:{}", searchBody);
        log.info("SubjectCategorys:{}", searchBody.getSubjectCategorys());
        log.info("echnologyCategorys:{}", searchBody.getTechnologyCategorys());
        int offset = (pageNum - 1) * pageSize ;
        return this.achievementTableMapper.fuzzyQuery(searchBody, offset, pageSize);
    }
}
