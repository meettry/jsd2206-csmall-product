package com.tedu.csmall.product.controller;

import com.tedu.csmall.product.pojo.dto.AddNewAttributeTemplateDTO;
import com.tedu.csmall.product.service.AttributeTemplateService;
import com.tedu.csmall.product.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Meettry
 * @date 2022/9/26 17:13
 */
@Slf4j
@RestController
@RequestMapping("/attributeTemplates")
public class AttributeTemplateController {
    @Resource
    private AttributeTemplateService attributeTemplateService;

    public AttributeTemplateController() {
        log.debug("创建控制器类对象:AttributeTemplateController");
    }


    // http://localhost:8080/attributeTemplates/add-new
    @GetMapping("/add-new")//请求路径
    public JsonResult addNew(AddNewAttributeTemplateDTO attributeTemplateDTO) {
        System.out.println("开始处理控制层");
        attributeTemplateService.addNew(attributeTemplateDTO);
        log.warn("attributeTemplateDTO="+attributeTemplateDTO);
        return JsonResult.ok();
    }

    // http://localhost:8080/albums/9527/delete
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除相册】的请求，参数：{}", id);
        attributeTemplateService.delete(id);
        return JsonResult.ok();
    }




}
