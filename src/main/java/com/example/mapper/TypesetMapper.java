package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Relatetype;
import com.example.entity.Type;
import com.example.entity.Typeset;

import java.util.List;

/**
 * <p>
 * 商品分类 - 图标关联表 Mapper 接口
 * </p>
 *
 * @author 作者
 * @since 2024-04-21
 */
public interface TypesetMapper extends BaseMapper<Relatetype> {

    //查询所有一级分类数据
    List<Typeset> getTypesetMapList();

    /**
     * 新增
     */
    int insert(Typeset typeset);

    /**
     * 修改
     */
    int updateById(Typeset typeset);

    /**
     * 删除
     */
    int deleteById(Integer id);
}
