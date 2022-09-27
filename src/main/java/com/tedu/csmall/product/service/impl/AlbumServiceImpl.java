package com.tedu.csmall.product.service.impl;

import com.tedu.csmall.product.exception.NameRepeatException;
import com.tedu.csmall.product.mapper.AlbumMapper;
import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import com.tedu.csmall.product.pojo.entity.Album;
import com.tedu.csmall.product.service.AlbumService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 处理相册数据的业务实现类
 *
 * @author Meettry
 * @date 2022/9/26 14:24
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper mapper;


    @Override
    public void addNew(AddNewAlbumDTO albumDTO)   {
        String name = albumDTO.getName();
        int count = mapper.countByName(name);
        if (count != 0) {
            throw new NameRepeatException();
        }
        Album album = new Album();
        BeanUtils.copyProperties(albumDTO,album);
        album.setGmtCreate(LocalDateTime.now());
        album.setGmtModified(album.getGmtCreate());
        mapper.insert(album);

    }
}
