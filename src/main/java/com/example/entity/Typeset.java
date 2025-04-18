package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 图标表
 * </p>
 *
 * @author 作者
 * @since 2024-04-21
 */
@Data
@TableName("typeset")
public class Typeset implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 一级分类名
     */
    private String name;

    /**
     * 分类描述
     */
    private String description;

    /** 逻辑删除 */
    @TableLogic
    private Integer deleted;

    /**
     * 对应的二级分类
     */
    @TableField(exist = false)
    private List<Type> types;




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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Typeset{" +
            "id=" + id +
            ", name=" + name +
        "}";
    }
}
