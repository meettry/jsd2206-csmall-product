package com.tedu.csmall.product.service;

import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import com.tedu.csmall.product.pojo.dto.AddNewAttributeTemplateDTO;

/**
 * 处理属性模板的业务实现类
 *
 * @author Meettry
 * @date 2022/9/28 19:18
 */
public interface AttributeTemplateService {

    /**
     * 添加业务模板
     * @param attributeTemplateDTO 相册数据
     */
    void addNew(AddNewAttributeTemplateDTO attributeTemplateDTO)  ;

    /**
     * 删除业务模板
     * @param id 业务模板id
     */
    void delete(Long id);
}
