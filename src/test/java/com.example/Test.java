package com.example;


import com.example.entity.Carousel;
import com.example.mapper.CarouselMapper;
import com.example.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class Test {

    @Resource
    private CarouselService carouselService;

    @org.junit.jupiter.api.Test
    void selectAllTest(){
        System.out.println(carouselService.selectAll().get(0));
        //System.out.println(1);
    }

}
