package com.tedu.csmall.product.schedule;

import com.tedu.csmall.product.mapper.BrandMapper;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import com.tedu.csmall.product.repo.BrandRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 处理缓存的计划任务类
 */
@Slf4j
@Component
public class CacheSchedule {
    public CacheSchedule() {
        log.debug("创建计划任务类对象:CacheSchedule");
    }

    @Autowired
    BrandRedisRepository brandRedisRepository;
    @Autowired
    BrandMapper brandMapper;

    // @Scheduled注解的属性配置:
    // fixRate属性:执行计划任务方法的时间间隔(毫秒)
    // fixDelay属性:上次执行结束后,间隔(毫秒)再次执行
    // cron:使用一个字符串,其中包含6~7个值,每个值之间使用1个空格进行分隔.字符串中的各个值分别表示:秒 分 时 日 月 周 [年]
    // >> 例如：cron = "56 34 12 2 1 ? 2035"，则表示2035年1月2日12:34:56将执行此计划任务，无论这一天是星期几
    // >> 以上各值都可以使用通配符，使用星号（*）则表示任意值，使用问号（?）表示不关心具体值，并且，问号只能用于“周（星期）”和“日”这2个位置
    // >> 以上各值，可以使用“x/x”格式的值，例如，分钟对应的值使用“1/5”，则表示当分钟值为1的那一刻开始执行，往后每间隔5分钟执行一次
    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void a() {
        log.debug("开始处理缓存的计划任务");

        log.debug("删除缓存中原有的品牌数据");
        Long result = brandRedisRepository.deleteAll();
        log.debug("共删除{}条数据", result);

        log.debug("从mapper中读取品牌列表");
        List<BrandListItemVO> list = brandMapper.list();

        log.debug("将品牌列表写入到Redis");
        brandRedisRepository.save(list);

        log.debug("逐一根据id从MySQL中读取品牌详情,并写入到Redis");
        for (BrandListItemVO item : list) {
            BrandStandardVO brand = brandMapper.getStandardById(item.getId());
            brandRedisRepository.save(brand);
        }
    }
}
