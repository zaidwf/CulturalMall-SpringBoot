package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品分类信息表
*/
@Data
@TableName("type")
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /** 分类名称 */
    private String name;

    private String typesetId;

    @TableField(exist = false)
    private String typesetName;


    public String getTypesetId() {
        return typesetId;
    }

    public void setTypesetId(String typesetId) {
        this.typesetId = typesetId;
    }

    public String getTypesetName() {
        return typesetName;
    }

    public void setTypesetName(String typesetName) {
        this.typesetName = typesetName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
