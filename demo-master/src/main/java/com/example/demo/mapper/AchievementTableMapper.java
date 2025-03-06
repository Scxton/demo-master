package com.example.demo.mapper;

import com.example.demo.model.AchievementTable;
import com.example.demo.model.SearchBody;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (AchievementTable)表数据库访问层
 *
 * @author makejava
 * @since 2024-12-11 10:50:06
 */
public interface AchievementTableMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param achievementId 主键
     * @return 实例对象
     */
    AchievementTable queryById(Integer achievementId);

    /**
     * 新增数据
     *
     * @param achievementTable 实例对象
     * @return 影响行数
     */
    Integer insert(AchievementTable achievementTable);

    /**
     * 修改数据
     *
     * @param achievementTable 实例对象
     * @return 影响行数
     */
    Integer update(AchievementTable achievementTable);

    /**
     * 通过主键删除数据
     *
     * @param achievementId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer achievementId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<AchievementTable> queryAll();

    Integer countAchievements();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AchievementTable> queryAllWithPagination(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过专利作为筛选条件查询
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AchievementTable> queryAllWithPatent(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过论文作为筛选条件查询
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AchievementTable> queryAllWithPaper(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过其他作为筛选条件查询
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AchievementTable> queryAllWithOthers(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过审批记录表中的待审批作为筛选条件查询
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AchievementTable> queryAllWithPaginationForApproval(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 分页模糊查询待审核数据
     *
     * @return 对象列表
     */
    List<AchievementTable> queryByLikeApproval(@Param("achievementName") String achievementName, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 分页模糊查询所有成果数据
     *
     * @return 对象列表
     */
    List<AchievementTable> queryByLike(@Param("achievementName") String achievementName, @Param("offset") int offset, @Param("limit") int limit);

    Integer restoreById(Integer achievementId);
    //一键恢复所有被删除的数据
    Integer restoreAll();

    /*
     * 精确条件查询
     */
    List<AchievementTable> queryAllByLimit(AchievementTable achievementTable);
    /*
     * 模糊条件查询
     */
    List<AchievementTable> fuzzyQuery(SearchBody searchBody, @Param("offset") int offset , @Param("limit") int limit);

}

