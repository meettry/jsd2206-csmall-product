package com.tedu.csmall.product.service.impl;


import com.tedu.csmall.product.exception.ServiceException;
import com.tedu.csmall.product.mapper.BrandMapper;
import com.tedu.csmall.product.pojo.dto.AddNewBrandDTO;
import com.tedu.csmall.product.pojo.entity.Brand;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import com.tedu.csmall.product.repo.BrandRedisRepository;
import com.tedu.csmall.product.service.BrandService;
import com.tedu.csmall.product.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理品牌业务的实现类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRedisRepository repository;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    BrandRedisRepository brandRedisRepository;


    public BrandServiceImpl() {
        log.info("创建业务对象：BrandServiceImpl");
    }

    @Override
    public void addNew(AddNewBrandDTO brandAddNewDTO) {
        log.debug("开始处理【添加品牌】的业务，参数：{}", brandAddNewDTO);

        // 检查品牌名称是否已经被占用
        String name = brandAddNewDTO.getName();
        int countByName = brandMapper.countByName(name);
        log.debug("尝试添加的品牌名称是：{}，在数据库中此名称的品牌数量为：{}", name, countByName);
        if (countByName > 0) {
            String message = "添加品牌失败，品牌名称【" + brandAddNewDTO.getName() + "】已经被占用！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR, message);
        }

        // 创建品牌对象，用于插入到数据表
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        brand.setSales(0);
        brand.setProductCount(0);
        brand.setCommentCount(0);
        brand.setPositiveCommentCount(0);

        // 插入数据
        log.debug("即将向数据库中插入数据：{}", brand);
        int rows = brandMapper.insert(brand);
        if (rows != 1) {
            String message = "添加品牌失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR, message);
        }
    }

    @Override
    public void delete(Long id) {
        log.debug("开始处理【删除品牌】的业务，参数：{}", id);
        // 调用Mapper对象的getDetailsById()方法执行查询
        BrandStandardVO queryResult = brandMapper.getStandardById(id);
        // 判断查询结果是否为null
        if (queryResult == null) {
            // 是：此id对应的数据不存在，则抛出异常(ERR_NOT_FOUND)
            String message = "删除品牌失败，尝试删除的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        // 调用Mapper对象的deleteById()执行删除，并获取返回值
        int rows = brandMapper.deleteById(id);
        // 判断以上返回值是否不为1
        if (rows != 1) {
            // 是：抛出异常(ERR_DELETE)
            String message = "删除品牌失败，服务器忙，请稍后再次尝试！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR, message);
        }
    }

    @Override
    public BrandStandardVO getStandardById(Long id) {
        log.debug("开始处理【根据id查询品牌详情】的业务，参数：{}", id);
//        BrandStandardVO brand = brandMapper.getStandardById(id);
        BrandStandardVO brandStandardVO = repository.get(id);
        if (brandStandardVO == null) {
            String message = "获取品牌详情失败，尝试访问的数据不存在！";
            log.warn(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        return brandStandardVO;
    }


    @Override
    public List<BrandListItemVO> list() {
        log.debug("开始处理【查询品牌列表】的业务");
//        return brandMapper.list();
        return repository.list();
    }

    @Override
    public void rebuildCache() {
        log.debug("删除Redis中原有的品牌数据");
        brandRedisRepository.deleteAll();

        log.debug("从MySQL中读取品牌列表");
        List<BrandListItemVO> brands = brandMapper.list();

        log.debug("将品牌列表写入到Redis");
        brandRedisRepository.save(brands);

        log.debug("逐一根据id从MySQL中读取品牌详情，并写入到Redis");
        for (BrandListItemVO item : brands) {
            BrandStandardVO brand = brandMapper.getStandardById(item.getId());
            brandRedisRepository.save(brand);
        }
    }
}
