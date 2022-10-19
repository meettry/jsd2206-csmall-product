package com.tedu.csmall.product.schedule;

import com.tedu.csmall.product.mapper.BrandMapper;
import com.tedu.csmall.product.pojo.vo.BrandListItemVO;
import com.tedu.csmall.product.pojo.vo.BrandStandardVO;
import com.tedu.csmall.product.repo.BrandRedisRepository;
import com.tedu.csmall.product.service.BrandService;
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
    BrandService brandService;

    // @Scheduled注解的属性配置:
    // fixRate属性:执行计划任务方法的时间间隔(毫秒)
    // fixDelay属性:上次执行结束后,间隔(毫秒)再次执行
    // cron:使用一个字符串,其中包含6~7个值,每个值之间使用1个空格进行分隔.字符串中的各个值分别表示:秒 分 时 日 月 周 [年]
    // >> 例如：cron = "56 34 12 2 1 ? 2035"，则表示2035年1月2日12:34:56将执行此计划任务，无论这一天是星期几
    // >> 以上各值都可以使用通配符，使用星号（*）则表示任意值，使用问号（?）表示不关心具体值，并且，问号只能用于“周（星期）”和“日”这2个位置
    // >> 以上各值，可以使用“x/x”格式的值，例如，分钟对应的值使用“1/5”，则表示当分钟值为1的那一刻开始执行，往后每间隔5分钟执行一次
    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void a() {
        log.debug("开始执行处理缓存的计划任务……");
        brandService.rebuildCache();
        log.debug("处理缓存的计划任务执行完成！");
    }
}
