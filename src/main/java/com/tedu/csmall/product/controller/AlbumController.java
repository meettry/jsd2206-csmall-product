package com.tedu.csmall.product.controller;

import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import com.tedu.csmall.product.service.AlbumService;
import com.tedu.csmall.product.web.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Meettry
 * @date 2022/9/26 17:13
 */
@Slf4j
@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    public AlbumController() {
        System.out.println("创建控制器类对象:AlbumController");
    }


    // http://localhost:8080/albums/add-new
    @PostMapping("/add-new")//请求路径
    public JsonResult addNew(AddNewAlbumDTO albumDTO) {
        albumService.addNew(albumDTO);
        return JsonResult.ok();
    }

    // http://localhost:8080/albums/9527/delete
    @RequestMapping("/{id:[0-9]+}/delete")
    public JsonResult delete(@PathVariable Long id) {
        log.debug("开始处理【删除相册】的请求，参数：{}", id);
        albumService.delete(id);
        return JsonResult.ok();
    }

    @Deprecated
    @RequestMapping("/{id:[a-z]+}/delete")
    public JsonResult delete(@PathVariable String id) {
        log.debug("【测试】开始处理【删除相册】的请求，参数（纯字母）：{}", id);
        return JsonResult.ok();
    }

    @Deprecated
    @RequestMapping("/delete/test")
    public JsonResult deleteTest() {
        log.debug("【测试】开始处理【删除相册】的请求，这只是一个测试，没有实质功能！");
        return JsonResult.ok();
    }
}
