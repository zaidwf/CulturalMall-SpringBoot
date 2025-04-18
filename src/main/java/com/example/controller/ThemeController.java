package com.example.controller;


import com.example.common.Result;
import com.example.entity.Goods;
import com.example.entity.Theme;
import com.example.service.ThemeService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@Controller返回一个视图@RestController返回一个对象
@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Resource
    private ThemeService themeService;

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Theme> list = themeService.selectAll();
        return Result.success(list);
    }
    /**
     * 根据ID查询
     */
    @GetMapping("/selectById")
    public Result selectById(@RequestParam Integer id) {
        Theme theme = themeService.selectById(id);
        return Result.success(theme);
    }
    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Theme> page = themeService.selectPage(pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        themeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        themeService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Theme theme) {
        themeService.updateById(theme);
        return Result.success();
    }
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Theme theme) {
        themeService.add(theme);
        return Result.success();
    }
}
