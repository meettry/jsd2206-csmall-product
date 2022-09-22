package com.tedu.csmall.product;

import com.tedu.csmall.product.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

@SpringBootTest
class Jsd2206CsmallProductApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void testConnection() throws SQLException {
         Connection connection = dataSource.getConnection();
        System.out.println("成功");
    }
    @Test
    void testLombok(){
        Album album = new Album();
        LocalDateTime gmtModified = album.getGmtModified();
        System.out.println(gmtModified);
    }

}
