package com.tearsmart.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  * <p>
  *     项目启动类
  * </p>
  * @author tear-smart
  * @date 2018/12/5 14:39
  */
@MapperScan(basePackages = "com.tearsmart.seckill")
@SpringBootApplication
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
