package com.tedu.csmall.product.mapper;

import com.tedu.csmall.product.pojo.entity.Album;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  Meettry
 * @date  2022/9/22 11:26
 */
@Repository
public interface AlbumMapper {
    /**
     * 插入相册数据
     *
     * @param album 相册数据
     * @return 受影响的行数
     */
    int insert(Album album);

    /**
     * 通过id删除数据
     * @param id 相册id
     * @return 受影响的行数
     */
    int deleteById(Long id);

    /**
     * 统计表中总数
     * @return 表中总数
     */
    int count();

}
