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
     * 品牌相关数据在Redis中的前缀
     */
    String BRAND_KEY_PREFIX = "brand:";
    /**
     * 品牌数据项在Redis中的Key前缀
     */
    String BRAND_ITEM_KEY_PREFIX = BRAND_KEY_PREFIX + "item:";
    /**
     * 品牌列表在Redis中的Key
     */
    String BRAND_LIST_KEY = BRAND_KEY_PREFIX + "list";

    String BRAND_ALL_KEYS_KEY = "brand:all-keys";

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

    /**
     * 删除全部品牌数据,包括各品牌详情数据和品牌列表等
     * @return 返回成功删除的数量
     */
    Long deleteAll();

}
