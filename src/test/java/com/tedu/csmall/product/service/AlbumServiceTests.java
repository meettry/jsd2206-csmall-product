package com.tedu.csmall.product.service;

import com.tedu.csmall.product.exception.ServiceException;
import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Meettry
 * @date 2022/9/30 15:39
 */
@Slf4j
@SpringBootTest
public class AlbumServiceTests {

    @Autowired
    AlbumService service;

    @Test
    void contextLoads() {
        System.out.println(service);
    }

    @Test
    void testAddNew() {
        AddNewAlbumDTO albumAddNewDTO = new AddNewAlbumDTO();
        albumAddNewDTO.setName("测试相册名称002");
        albumAddNewDTO.setDescription("测试相册简介002");
        albumAddNewDTO.setSort(88);

        try {
            service.addNew(albumAddNewDTO);
            System.out.println("添加相册成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testDelete() {
        Long id = 14L;

        try {
            service.delete(id);
            System.out.println("删除相册成功！");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testList(){
        Object result = service.list();
        log.trace("查询到的结果为"+result);
    }

}
