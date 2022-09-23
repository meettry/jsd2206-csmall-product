package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.mapper.AlbumMapper;
import com.tedu.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Meettry
 * @date 2022/9/22 14:11
 */
@SpringBootTest
public class AlbumMapperTests {

    @Autowired()
    private AlbumMapper albumMapper;
    @Test
    public void testInsert(){
        Album album = new Album();
        album.setName("测试相册005");
        album.setDescription("测试简介005");
        album.setSort(99);//取值必须是[0,255]
        System.out.println(album);
        int rows = albumMapper.insert(album);
        System.out.println(rows);
    }

    @Test
    void testDeleteById(){
        int i = albumMapper.deleteById(1L);
        System.out.println("删除成功"+i);
    }

    @Test
    void testCount(){
        int count = albumMapper.count();
        System.out.println("数量"+count);

    }

}
