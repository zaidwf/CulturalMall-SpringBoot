package com.example.mapper;

import com.example.entity.Topic;

import java.util.List;

public interface TopicMapper {
    //List<Topic> getTopicMapList();

    Topic selectById(Integer id);

    List<Topic> selectAll();

    int updateById(Topic topic);

    int deleteById(Integer id);

    int insert(Topic topic);
}
