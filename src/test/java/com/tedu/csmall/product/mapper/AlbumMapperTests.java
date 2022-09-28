package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.mapper.AlbumMapper;
import com.tedu.csmall.product.pojo.entity.Album;
import com.tedu.csmall.product.pojo.vo.AlbumListItemVO;
import com.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Meettry
 * @date 2022/9/22 14:11
 */
@SpringBootTest
@Slf4j
public class AlbumMapperTests {

    @Resource
    private AlbumMapper mapper;


    @Test
    public void testInsert(){
        Album album = new Album();
        album.setName("测试相册000");
        album.setDescription("测试简介000");
        album.setSort(99);//取值必须是[0,255]
        log.trace("插入数据的参数为:"+album);
        int rows = mapper.insert(album);
        log.info("插入数据完成，受影响的行数=" + rows);
    }

    @Test
    public void testInsertBatch(){
        List<Album> list=new ArrayList<>();
        for (int i =0;i<=5;i++) {
            Album album = new Album();
            album.setName("测试"+i);
            album.setDescription("测试简介"+i);
            album.setSort(i);//取值必须是[0,255]
            list.add(album);
        }
        log.trace("插入数据的参数为:"+list);
        int rows = mapper.insertBatch(list);
        log.info("插入数据完成，受影响的行数="+rows);
    }


    @Test
    void testDeleteById(){
        int rows = mapper.deleteById(1L);
        log.info("删除成功,受影响行数"+rows);
    }

    @Test
    void testDeleteByIds(){
        Long[] array = {2L,3L};
        int rows = mapper.deleteByIds(array);
        log.info("删除成功,受影响行数"+rows);
    }

    @Test
    void TestUpdateById(){
        Album album = new Album();
        album.setId(5L);
        album.setName("很新的相册名称");
        album.setDescription("很新的相册简");
        album.setSort(199);
        int rows = mapper.updateById(album);
        log.info("删除成功,受影响行数"+rows);
    }

    @Test
    void testCount(){
        int count = mapper.count();
        log.info("统计成功,该表共有"+count+"行");

    }

    @Test
    void testGetStandardById(){
        long id=4L;
        //检验结果用Object
        Object result =  mapper.getStandardById(id);
        log.trace("查询到的结果为"+result);
    }

    @Test
    void testList(){
        Object result = mapper.list();
        log.trace("查询到的结果为"+result);
    }


}
