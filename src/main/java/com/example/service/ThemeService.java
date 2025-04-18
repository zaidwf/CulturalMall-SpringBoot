package com.example.service;

import com.example.entity.Carousel;
import com.example.entity.Theme;
import com.example.mapper.ThemeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ThemeService {


    @Resource
    private ThemeMapper themeMapper;

    public List<Theme> selectAll() {
        return themeMapper.getThemeMapList();
    }

    public Theme selectById(Integer id) {
        return themeMapper.selectById(id);
    }

    public PageInfo<Theme> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Theme> list = themeMapper.getThemeMapList();//selectAll()
        return PageInfo.of(list);
    }

    public void updateById(Theme theme) {
        themeMapper.updateById(theme);
    }

    public void deleteById(Integer id) {
        themeMapper.deleteById(id);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            themeMapper.deleteById(id);
        }
    }

    public void add(Theme theme) {
        themeMapper.insert(theme);
    }
}
