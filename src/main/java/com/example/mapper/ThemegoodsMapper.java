package com.example.mapper;

import com.example.entity.Themegoods;
import com.example.entity.Type;

import java.util.List;

/**
 * 操作themegoods相关数据接口
*/
public interface ThemegoodsMapper {

    /**
      * 新增
    */
    int insert(Themegoods themegoods);

    /**
      * 商品id删除
    */
    int deleteById(Integer id);


    /**
      * 根据ID查询
    */
    Themegoods selectById(Integer id);

}
