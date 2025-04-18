package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("themegoods")
public class Themegoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主题id
     */
    private Integer themeId;

    /**
     * 商品id
     */
    @TableId(value = "goods_id")
    private Integer goodsId;

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Themegoods{" +
            "themeId=" + themeId +
            ", goodsId=" + goodsId +
        "}";
    }
}
