package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.Brand;
import com.tedu.csmall.product.pojo.entity.Brand;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;

import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/23 9:51
 */
public interface BrandMapper {
    /**
     * 插入品牌数据
     *
     * @param brand 品牌数据
     * @return 受影响的行数
     */
    int insert(Brand brand);

    /**
     * 批量插入品牌数据
     *
     * @param brands 若干个品牌数据的集合
     * @return 受影响的行数
     */
    int insertBatch(List<Brand> brands);

    /**
     * 根据id删除品牌数据
     *
     * @param id 品牌id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 批量删除品牌
     *
     * @param ids 需要删除的若干个品牌的id
     * @return 受影响的行数
     */
    int deleteByIds(Long[] ids);

    /**
     * 更新品牌数据
     *
     * @param Brand 封装了品牌的id和需要更新的新数据的对象
     * @return 受影响的行数
     */
    int updateById(Brand Brand);

    /**
     * 统计品牌数据的数量
     *
     * @return 品牌数据的数量
     */
    int count();
    
    /**
     * 根据id查询品牌标准信息
     * @param Id 品牌id
     * @return 匹配的品牌的标准信息,如果没有匹配的数据,则返回null
     */
    BrandStandardVO getStandardById(Long Id);

    /**
     * 查询品牌列表
     *
     * @return 品牌列表
     */
    List<BrandListItemVO> list();
}
