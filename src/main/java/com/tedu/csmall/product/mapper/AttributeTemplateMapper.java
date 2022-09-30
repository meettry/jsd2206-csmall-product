package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.AttributeTemplate;
import com.tedu.csmall.product.pojo.vo.AttributeTemplateListItemVO;
import com.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/22 15:23
 */
@Repository
public interface AttributeTemplateMapper {
    /**
     * 插入属性模板
     * @param attributeTemplate 属性模板数据
     * @return 受影响的行数
     */
    int insert(AttributeTemplate attributeTemplate);

    /**
     * 批量插入属性模板
     * @param attributeTemplates 属性模板数据
     * @return 受影响的行数
     */
    int insertBatch(List<AttributeTemplate> attributeTemplates);

    /**
     * 根据id删除属性模板数据
     *
     * @param id 相册id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 批量删除属性模板
     *
     * @param ids 需要删除的若干个属性模板的id
     * @return 受影响的行数
     */

    int deleteByIds(Long[] ids);

    /**
     * 更新属性模板数据
     *
     * @param attributeTemplate 封装了属性模板的id和需要更新的新数据的对象
     * @return 受影响的行数
     */
    int updateById(AttributeTemplate attributeTemplate);

    /**
     * 统计属性模板数据的数量
     *
     * @return 属性模板数据的数量
     */
    int count();

    /**
     * 查询属性模板名字是否存在
     *
     * @return 返回0:属性模板名不存在;返回不为0:属性模板存在
     */
    int countByName(String name);

    /**
     * 根据id查询属性模板标准信息
     * @param Id 属性模板id
     * @return 匹配的属性模板的标准信息,如果没有匹配的数据,则返回null
     */
    AttributeTemplateStandardVO getStandardById(Long Id);

    /**
     * 查询属性模板列表
     *
     * @return 属性模板列表
     */
    List<AttributeTemplateListItemVO> list();




}
