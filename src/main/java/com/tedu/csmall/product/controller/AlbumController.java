package com.tedu.csmall.product.controller;

import com.tedu.csmall.product.exception.NameRepeatException;
import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import com.tedu.csmall.product.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Meettry
 * @date 2022/9/26 17:13
 */
@Slf4j
@RestController
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    public AlbumController() {
        System.out.println("创建控制器类对象:AlbumController");
    }

    @RequestMapping("/Album/add-new")//请求路径
    public String addNew(AddNewAlbumDTO albumDTO) {
        albumService.addNew(albumDTO);
        return "添加相册成功!";
    }
}
