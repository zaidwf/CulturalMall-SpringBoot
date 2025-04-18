package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 商品分类 - 图标关联表
 * </p>
 *
 * @author 作者
 * @since 2024-04-21
 */
@Data
@TableName("relatetype")
public class Relatetype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer typeId;

    /**
     * 一级分类id
     */
    private Integer typesetId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypesetId() {
        return typesetId;
    }

    public void setTypesetId(Integer typesetId) {
        this.typesetId = typesetId;
    }
}
