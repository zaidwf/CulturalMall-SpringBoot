package com.example.controller;


import com.example.common.Result;
import com.example.entity.Goods;
import com.example.entity.Type;
import com.example.entity.Typeset;
import com.example.service.TypesetService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/typeset")
public class TypesetController {
    @Resource
    private TypesetService typesetService;

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Typeset> list = typesetService.selectAll();
        return Result.success(list);
    }
    /**
     * 新增一级分类
     */
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Typeset typeset) {
        typesetService.add(typeset);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Typeset typeset) {
        typesetService.updateById(typeset);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        typesetService.deleteById(id);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Typeset> page = typesetService.selectPage(pageNum, pageSize);
        return Result.success(page);
    }
}
