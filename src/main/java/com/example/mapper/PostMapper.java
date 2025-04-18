package com.example.mapper;

import com.example.entity.Post;

import java.util.List;

public interface PostMapper {

    Post selectById(Integer id);

    List<Post> selectAll();

    int updateById(Post post);

    int deleteById(Integer id);

    int insert(Post post);

    List<Post> selectByTopicId(Integer id);
}
