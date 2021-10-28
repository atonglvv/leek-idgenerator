package cn.atong.leek.idgenerator;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: leek-idgenerator
 * @description: 发号器服务端
 * @author: atong
 * @create: 2021-04-14 11:07
 */

@SpringBootApplication
@EnableDubbo
public class IdgeneratorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdgeneratorServiceApplication.class, args);
    }

}