package com.tedu.csmall.product.service.impl;

import com.tedu.csmall.product.exception.ServiceException;
import com.tedu.csmall.product.mapper.AlbumMapper;
import com.tedu.csmall.product.pojo.dto.AddNewAlbumDTO;
import com.tedu.csmall.product.pojo.entity.Album;
import com.tedu.csmall.product.pojo.vo.AlbumStandardVO;
import com.tedu.csmall.product.service.AlbumService;
import com.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper mapper;


    @Override
    public void addNew(AddNewAlbumDTO albumDTO)   {
        String name = albumDTO.getName();
        int count = mapper.countByName(name);
        if (count != 0) {
            throw new ServiceException(ServiceCode.ERR,"添加相册失败，尝试添加的相册名称已经被占用！");
        }
        Album album = new Album();
        BeanUtils.copyProperties(albumDTO,album);
        album.setGmtCreate(LocalDateTime.now());
        album.setGmtModified(album.getGmtCreate());
        mapper.insert(album);
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理删除相册,参数{}",id);
        AlbumStandardVO result = mapper.getStandardById(id);
        if (result == null) {
            log.warn("相册删除失败,数据不存在");
            throw new ServiceException(ServiceCode.ERR,"相册删除失败,数据不存在");
        }
        log.debug("正在删除相册");
        int row = mapper.deleteById(id);
        if(row!=0){
            log.debug("删除成功");
        }
    }
}
