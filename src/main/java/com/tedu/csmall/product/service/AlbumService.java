package com.tedu.csmall.product.service;

import com.tedu.csmall.product.exception.NameRepeatException;
import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;

/**
 * 处理相册数据的业务接口
 *
 * @author Meettry
 * @date 2022/9/26 14:22
 */

public interface AlbumService {

    void addNew(AddNewAlbumDTO albumDTO)  ;
}
