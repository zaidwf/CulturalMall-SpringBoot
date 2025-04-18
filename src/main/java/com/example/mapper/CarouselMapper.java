package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Carousel;
import com.example.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CarouselMapper extends BaseMapper<Carousel> {

    /**
     * 查询所有
     */
    List<Carousel> selectAll();

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 新增
     */
    int insert(Carousel carousel);
}
