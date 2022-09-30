package com.tedu.csmall.product.service.impl;

import com.tedu.csmall.product.exception.ServiceException;
import com.tedu.csmall.product.mapper.AttributeTemplateMapper;
import com.tedu.csmall.product.pojo.dto.AddNewAttributeTemplateDTO;
import com.tedu.csmall.product.pojo.entity.Album;
import com.tedu.csmall.product.pojo.entity.AttributeTemplate;
import com.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import com.tedu.csmall.product.pojo.vo.AttributeTemplateStandardVO;
import com.tedu.csmall.product.service.AttributeTemplateService;
import com.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 数据属性模板数据的业务实现类
 * @author Meettry
 * @date 2022/9/28 19:23
 */
@Service
@Slf4j
public class AttributeTemplateImpl implements AttributeTemplateService {

    @Autowired
    private AttributeTemplateMapper mapper;



    public AttributeTemplateImpl() {
        log.debug("构造AttributeTemplateImpl对象");
    }

    @Override
    public void addNew(AddNewAttributeTemplateDTO attributeTemplateDTO) {
        log.info("开始处理添加业务");
        String name = attributeTemplateDTO.getName();
        int count = mapper.countByName(name);
        if (count != 0) {
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,"添加属性模板失败，尝试添加的属性模板名称已经被占用！");
        }
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        BeanUtils.copyProperties(attributeTemplateDTO,attributeTemplate);
        attributeTemplate.setGmtCreate(LocalDateTime.now());
        attributeTemplate.setGmtModified(attributeTemplate.getGmtCreate());
        mapper.insert(attributeTemplate);
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理删除属性模板,参数{}",id);
        AttributeTemplateStandardVO result = mapper.getStandardById(id);
        if (result == null) {
            log.warn("属性模板删除失败,数据不存在");
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,"属性模板删除失败,数据不存在");
        }
        log.debug("正在删除属性模板");
        int row = mapper.deleteById(id);
        if(row!=0){
            log.debug("删除成功");
        }
    }
}
