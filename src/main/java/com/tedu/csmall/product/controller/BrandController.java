package com.tedu.csmall.product.controller;

import com.tedu.csmall.product.pojo.dto.AddNewBrandDTO;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import com.tedu.csmall.product.service.BrandService;
import com.tedu.csmall.product.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理品牌相关请求的控制器
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/brands")
@Api(tags = "02. 品牌管理模块")
@Validated
public class BrandController {

    @Autowired
    private BrandService brandService;

    public BrandController() {
        log.info("创建控制器：BrandController");
    }

    // http://localhost:9080/brands/add-new
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 100)
    @PostMapping("/add-new")
    public JsonResult<Void> addNew(@Validated AddNewBrandDTO brandAddNewDTO) {
        log.debug("开始处理【添加品牌】的请求：{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    // http://localhost:9080/brands/9527/delete
    @ApiOperation("删除品牌")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id", value = "品牌id", required = true, dataType = "long")
    @PostMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id) {
        log.debug("开始处理【删除品牌】的请求：id={}", id);
        brandService.delete(id);
        return JsonResult.ok();
    }

    // http://localhost:9080/brands/9527
    @ApiOperation("根据id查询品牌详情")
    @ApiOperationSupport(order = 400)
    @GetMapping("/{id:[0-9]+}")
    public JsonResult<BrandStandardVO> getStandardById(@PathVariable Long id) {
        log.debug("开始处理【根据id查询品牌详情】的请求，参数：{}", id);
        BrandStandardVO brand = brandService.getStandardById(id);
        return JsonResult.ok(brand);
    }

    // http://localhost:9080/brands
    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 410)
    @GetMapping("")
    public JsonResult<List<BrandListItemVO>> list() {
        log.debug("开始处理【查询品牌列表】的请求……");
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }

}
