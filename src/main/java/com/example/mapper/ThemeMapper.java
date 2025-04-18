package com.example.mapper;

import com.example.entity.Theme;

import java.util.List;

public interface ThemeMapper {
    List<Theme> getThemeMapList();

    Theme selectById(Integer id);

    List<Theme> selectAll();

    int updateById(Theme theme);

    int deleteById(Integer id);

    int insert(Theme theme);
}
