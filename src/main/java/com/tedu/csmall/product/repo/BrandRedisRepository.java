package com.tedu.csmall.product.repo;

import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 处理品牌缓存的数据访问接口
 */
@Repository
public interface BrandRedisRepository {

    /**
     * 将数据写入Redis
     * @param brandStandardVO 品牌数据
     */
    void save(BrandStandardVO brandStandardVO);

    /**
     * 从Redis中读取品牌数据
     * @param id 品牌id
     * @return 匹配的品牌数据,若没有相对应的数据返回null
     */
    BrandStandardVO get(Long id);

    /**
     * 向Redis中写入品牌列表
     * @param brands 品牌的数据
     */
    void save(List<BrandListItemVO> brands);

    /**
     * 从Redis中读取品牌列表
     * @return 品牌列表的集合
     */
    List<BrandListItemVO> list();

    /**
     * 从Redis中读取品牌列表
     * @param start 读取数据起始下标
     * @param end 读取数据终止下标
     * @return 品牌列表的集合
     */
    List<BrandListItemVO> list(long start,long end);


}
