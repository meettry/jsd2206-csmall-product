package com.tedu.csmall.product.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import com.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import com.tedu.csmall.product.service.AlbumService;
import com.tedu.csmall.product.web.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/26 17:13
 */
@Slf4j
@RestController
@Api(tags = "01. 相册管理模块")
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    public AlbumController() {
        System.out.println("创建控制器类对象:AlbumController");
    }


    // http://localhost:8080/albums/add-new
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 100)
    @RequestMapping("/add-new")//请求路径
    public JsonResult<Void> addNew(@Validated AddNewAlbumDTO albumDTO) {
        albumService.addNew(albumDTO);
        return JsonResult.ok();
    }

    // http://localhost:8080/albums/9527/delete
    @ApiOperation("删除相册")
    @ApiOperationSupport(order = 200)
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult<Void> delete(@PathVariable Long id) {
        log.debug("开始处理【删除相册】的请求，参数：{}", id);
        albumService.delete(id);
        return JsonResult.ok();
    }

    @ApiOperation("删除相册【测试1】")
    @ApiOperationSupport(order = 900)
    @Deprecated
    @RequestMapping("/{id:[a-z]+}/delete")
    public JsonResult<Void> delete(@PathVariable String id) {
        log.debug("【测试】开始处理【删除相册】的请求，参数（纯字母）：{}", id);
        return JsonResult.ok();
    }

    @ApiOperation("删除相册【测试2】")
    @ApiOperationSupport(order = 910)
    @Deprecated
    @ApiImplicitParam(name = "id",value = "相册id",paramType = "query")
    @RequestMapping("/delete/test")
    public JsonResult<Void> deleteTest(@Range(min = 1,message = "删除失败,id必须是1以上的正整数") Long id) {
        log.debug("【测试】开始处理【删除相册】的请求，这只是一个测试，没有实质功能！");
        return JsonResult.ok();
    }

    @ApiOperation("查询相册列表")
    @ApiOperationSupport(order = 420)
    @GetMapping("")
    public JsonResult<List<AlbumListItemVO>> list(){
        List<AlbumListItemVO> list = albumService.list();
        return JsonResult.ok(list);
    }
}
