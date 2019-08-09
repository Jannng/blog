package com.newegg.mis.mps.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by jt1n on 2019/8/9.
 */
@SpringBootApplication
@ServletComponentScan
public class BlogMain {
    public static void main(String[] args) {
        SpringApplication.run(BlogMain.class);
    }
}
