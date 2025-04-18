package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.entity.Business;
import com.example.entity.Carousel;
import com.example.entity.Comment;
import com.example.mapper.CarouselMapper;
import com.example.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CarouselService extends ServiceImpl<CarouselMapper, Carousel> {

    private final CarouselMapper carouselMapper;

    /**
     * 查询所有轮播图
     *
     * @return 轮播图
     */
    public List<Carousel> selectAll() {
        return carouselMapper.selectAll();
    }


    public Carousel selectById(Integer id) {
        return carouselMapper.selectById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            carouselMapper.deleteById(id);
        }
    }
    /**
     * 分页查询
     */
    public PageInfo<Carousel> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Carousel> list = carouselMapper.selectAll();
        return PageInfo.of(list);
    }
    /**
     * 新增轮播图
     */
    public void add(Carousel carousel) {
        carouselMapper.insert(carousel);

    }
}
