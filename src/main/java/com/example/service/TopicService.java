package com.example.service;


import com.example.entity.Topic;
import com.example.mapper.TopicMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicService {


    @Resource
    private TopicMapper topicMapper;

    public List<Topic> selectAll() {
        return topicMapper.selectAll();
    }//getTopicMapList()

    public Topic selectById(Integer id) {
        return topicMapper.selectById(id);
    }

    public PageInfo<Topic> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Topic> list = topicMapper.selectAll();
        return PageInfo.of(list);
    }

    public void updateById(Topic topic) {
        topicMapper.updateById(topic);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            topicMapper.deleteById(id);
        }
    }

    public void add(Topic topic) {
        topicMapper.insert(topic);
    }
}
