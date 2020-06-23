package com.msr.ucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tom
 * @version V1.0
 * @Package com.msr.ucenter
 * @date 2020/6/12 9:25
 * @Copyright © 株式会社多言语系统研究所
 */
@EnableDiscoveryClient
@MapperScan("com.msr.ucenter.mapper")
@ComponentScan(basePackages={"com.msr.ucenter","com.msr.common"})
@SpringBootApplication
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class,args);
    }
}
