package com.example.demo.service;

import com.example.demo.model.IntellectualProperty;
import com.example.demo.mapper.IntellectualPropertyMapper;
import com.example.demo.service.IntellectualPropertyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * (IntellectualProperty)表服务实现类
 *
 * @author makejava
 * @since 2025-01-02 14:00:31
 */
@Service
@Slf4j
public class IntellectualPropertyService implements IntellectualPropertyMapper {
    @Resource
    private IntellectualPropertyMapper intellectualPropertyMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param intellectualPropertyId 主键
     * @return 查询数据
     */
    @Override
    public IntellectualProperty queryById(Integer intellectualPropertyId) {
        return this.intellectualPropertyMapper.queryById(intellectualPropertyId);
    }

    /**
     * 新增数据
     *
     * @param intellectualProperty 实例对象
     * @return 插入状态
     */
    @Override
    public Integer insert(IntellectualProperty intellectualProperty) {
        return this.intellectualPropertyMapper.insert(intellectualProperty);
    }

    /**
     * 修改数据
     *
     * @param intellectualProperty 实例对象
     * @return 实例对象ID
     */
    @Override
    public Integer update(IntellectualProperty intellectualProperty) {
        this.intellectualPropertyMapper.update(intellectualProperty);
        return intellectualProperty.getIntellectualPropertyId();
    }

    /**
     * 通过主键删除数据
     *
     * @param intellectualPropertyId 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer intellectualPropertyId) {
        Integer res = this.intellectualPropertyMapper.deleteById(intellectualPropertyId);
        return res;
    }
    
    /**
     * 查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<IntellectualProperty> queryAll(){
        return this.intellectualPropertyMapper.queryAll();
     }
     
    /**
     * 分页查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<IntellectualProperty> queryAllWithPagination(int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.intellectualPropertyMapper.queryAllWithPagination(offset,pageSize);
     }

     /**
     * 分页模糊查询所有行数据
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<IntellectualProperty> queryByLike(String intellectualPropertyType, int pageNum, int pageSize){
        int offset = (pageNum - 1) * pageSize ;
        return this.intellectualPropertyMapper.queryByLike(intellectualPropertyType,offset,pageSize);
     }

     /**
     * 查询过期的专利
     *
     * @return 表中所有行数据
     *
     */
     @Override
     public List<IntellectualProperty> findByIsExpiredFalse(){
        return this.intellectualPropertyMapper.findByIsExpiredFalse();
     }

     /**
     * 更新专利信息
     *
     * @return id表示成功
     *
     */
     @Override
     public Integer updateIntellectualProperty(IntellectualProperty intellectualProperty){
        this.intellectualPropertyMapper.updateIntellectualProperty(intellectualProperty);
        return intellectualProperty.getIntellectualPropertyId();
     }

     /**
     * 统计专利数量
     *
     * @return 专利数量
     *
     */
     @Override
     public Integer countIntellectualProperties(){
        return this.intellectualPropertyMapper.countIntellectualProperties();
     }

     /**
     * 统计有效专利数量
     *
     * @return 有效专利数量
     *
     */
     @Override
     public Integer countActiveIntellectualProperties(){
        return this.intellectualPropertyMapper.countActiveIntellectualProperties();
     }

     /**
     * 定时检查专利状态
     * 24h 检查一次
     */
    @Scheduled(fixedRate = 60000 * 60 * 24)
    public void checkAndUpdateStatus() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");   //yyyy-MM-dd HH:mm:ss
        List<IntellectualProperty> intellectualProperties = this.findByIsExpiredFalse();
//        log.info("专利: {}", intellectualProperties.get(0).getExpirationDate());
        for (IntellectualProperty ip : intellectualProperties) {
            if (ip.getExpirationDate() != null) {
                String expirationDateStr = ip.getExpirationDate().substring(0, 10);
//                log.info("{}" , expirationDateStr);
                LocalDate expirationLocalDateTime = LocalDate.parse(expirationDateStr, formatter);
                if (expirationLocalDateTime.isBefore(now) || expirationLocalDateTime.isEqual(now)) {
                    ip.setRenewalStatus(false);
                    this.updateIntellectualProperty(ip);
                    log.info("专利过期：{}" , ip.getIntellectualPropertyId());
                }
            }
        }
    }

    /**
     * 更新专利续费状态
     *
     * @return id表示成功
     *
     */
    @Override
    public Integer updateRenewalStatus(String expirationDate, Integer intellectualPropertyId) {
        IntellectualProperty intellectualProperty = this.queryById(intellectualPropertyId);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = expirationDate.substring(0, 10);
        intellectualProperty.setExpirationDate(formattedDate);
        intellectualProperty.setRenewalStatus(true);
        return this.updateIntellectualProperty(intellectualProperty);
    }

    @Override
    public List<IntellectualProperty> queryWait(){
        return this.intellectualPropertyMapper.queryWait();
    }
}
