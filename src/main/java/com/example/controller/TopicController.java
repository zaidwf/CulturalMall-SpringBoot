package com.example.controller;


import com.example.common.Result;

import com.example.entity.Topic;

import com.example.service.TopicService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Resource
    private TopicService topicService;

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Topic> list = topicService.selectAll();
        return Result.success(list);
    }
    /**
     * 根据ID查询
     */
    @GetMapping("/selectById")
    public Result selectById(@RequestParam Integer id) {
        Topic topic = topicService.selectById(id);
        return Result.success(topic);
    }
    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Topic> page = topicService.selectPage(pageNum, pageSize);
        return Result.success(page);
    }
    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        topicService.deleteBatch(ids);
        return Result.success();
    }
    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Topic topic) {
        topicService.updateById(topic);
        return Result.success();
    }
    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Topic topic) {
        topicService.add(topic);
        return Result.success();
    }
}
