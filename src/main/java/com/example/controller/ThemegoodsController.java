package com.example.controller;
import com.example.common.Result;
import com.example.entity.Themegoods;
import com.example.service.ThemegoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/themegoods")
public class ThemegoodsController {

    @Resource
    private ThemegoodsService themegoodsService;
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Themegoods themegoods) {
        themegoodsService.add(themegoods);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        themegoodsService.deleteById(id);
        return Result.success();
    }

}
