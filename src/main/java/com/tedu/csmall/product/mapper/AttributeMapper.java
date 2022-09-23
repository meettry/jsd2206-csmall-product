package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.Attribute;
import com.tedu.csmall.product.pojo.vo.AttributeListItemVO;
import com.tedu.csmall.product.pojo.vo.AttributeStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/22 16:07
 */
@Repository
public interface AttributeMapper {
    int insert(Attribute attribute);

    /**
     * 批量插入属性数据
     *
     * @param attributes 若干个属性数据的集合
     * @return 受影响的行数
     */
    int insertBatch(List<Attribute> attributes);

    /**
     * 根据id删除属性数据
     *
     * @param id 属性id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 批量删除属性
     *
     * @param ids 需要删除的若干个属性的id
     * @return 受影响的行数
     */
    int deleteByIds(Long[] ids);

    /**
     * 更新属性数据
     *
     * @param attribute 封装了属性的id和需要更新的新数据的对象
     * @return 受影响的行数
     */
    int updateById(Attribute attribute);

    /**
     * 统计属性数据的数量
     *
     * @return 属性数据的数量
     */
    int count();

    /**
     * 根据id查询属性标准信息
     * @param Id 属性id
     * @return 匹配的属性的标准信息,如果没有匹配的数据,则返回null
     */
    AttributeStandardVO getStandardById(Long Id);

    /**
     * 查询属性列表
     *
     * @return 属性列表
     */
    List<AttributeListItemVO> list();
}
