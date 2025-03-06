package com.example.demo.mapper;

import com.example.demo.model.IntellectualProperty;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (IntellectualProperty)表数据库访问层
 *
 * @author makejava
 * @since 2025-01-02 14:00:31
 */
public interface IntellectualPropertyMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param intellectualPropertyId 主键
     * @return 实例对象
     */
    IntellectualProperty queryById(Integer intellectualPropertyId);

    /**
     * 新增数据
     *
     * @param intellectualProperty 实例对象
     * @return 影响行数
     */
    Integer insert(IntellectualProperty intellectualProperty);

    /**
     * 修改数据
     *
     * @param intellectualProperty 实例对象
     * @return 影响行数
     */
    Integer update(IntellectualProperty intellectualProperty);

    /**
     * 通过主键删除数据
     *
     * @param intellectualPropertyId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer intellectualPropertyId);

    /**
     *查询所有行数据
     *
     *return 表中所有行数据
     *
     */
    List<IntellectualProperty> queryAll();
    
    /**
     *分页查询所有行数据
     *
     *return 页中所有行数据
     *
     */
     List<IntellectualProperty> queryAllWithPagination (@Param("offset") int offset , @Param("limit") int limit);

     /**
     *通过like查询
     *
     *return 符合条件的行数据
     *
     */
     List<IntellectualProperty> queryByLike(@Param("intellectualPropertyType") String intellectualPropertyType,
                                              @Param("offset") int offset , @Param("limit") int limit);


     /**
     *查询未到期的知识产权记录
     *
     * @return 实例对象
     */
    List<IntellectualProperty> findByIsExpiredFalse();

    /**
     * 更新知识产权信息
     */
    Integer updateIntellectualProperty(IntellectualProperty intellectualProperty);

    /**
     * 统计数据
     */
    Integer countIntellectualProperties();

    /**
     * 统计未过期专利数量
     */
    Integer countActiveIntellectualProperties();

    Integer updateRenewalStatus(@Param("expirationDate") String expirationDate, @Param("intellectualPropertyId") Integer intellectualPropertyId);

    List<IntellectualProperty> queryWait();
}

