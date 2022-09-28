package com.tedu.csmall.product.service;

import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;

/**
 * 处理相册数据的业务接口
 *
 * @author Meettry
 * @date 2022/9/26 14:22
 */

public interface AlbumService {

    /**
     * 添加相册
     * @param albumDTO 相册数据
     */
    void addNew(AddNewAlbumDTO albumDTO)  ;

    /**
     * 删除相册
     * @param id 相册id
     */
    void delete(Long id);
}
