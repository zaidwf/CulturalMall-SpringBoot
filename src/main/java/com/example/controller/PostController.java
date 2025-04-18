package com.example.controller;

import com.example.common.Result;
import com.example.entity.*;
import com.example.entity.Post;
import com.example.service.PostService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    /**
     * 根据ID查询
     */
    @GetMapping("/selectByTopicId")
    public Result selectById(@RequestParam Integer id) {
        List<Post> list = postService.selectByTopicId(id);
        return Result.success(list);
    }
    /**
     * 用户新增贴
     */
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Post post) {
        postService.add(post);
        return Result.success();
    }
    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        postService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Post post) {
        postService.updateById(post);
        return Result.success();
    }


    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam("topicId") Integer id,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Post> page = postService.selectPage(id, pageNum, pageSize);
        return Result.success(page);
    }
}
