package com.tedu.csmall.product.service;

import com.tedu.csmall.product.pojo.dto.AddNewBrandDTO;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品牌业务接口
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Transactional
public interface BrandService {

    /**
     * 添加品牌
     *
     * @param brandAddNewDTO 品牌数据
     */
    void addNew(AddNewBrandDTO brandAddNewDTO);

    /**
     * 根据品牌id，删除品牌数据
     *
     * @param id 尝试删除的品牌的id
     */
    void delete(Long id);

    /**
     * 查询品牌列表
     *
     * @return 品牌列表，如果没有匹配的品牌，将返回长度为0的列表
     */
    List<BrandListItemVO> list();

    BrandStandardVO getStandardById(Long id);

}
