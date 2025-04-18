package com.example.service;

import com.example.entity.Themegoods;
import com.example.mapper.ThemegoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ThemegoodsService {

    @Resource
    private ThemegoodsMapper themegoodsMapper;

    public void add(Themegoods themegoods) {
        themegoodsMapper.insert(themegoods);
    }

    public void deleteById(Integer id) {
        themegoodsMapper.deleteById(id);
    }
}
