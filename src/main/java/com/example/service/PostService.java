package com.example.service;

import com.example.entity.Post;
import com.example.entity.Typeset;
import com.example.mapper.PostMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {


    @Resource
    private PostMapper postMapper;

    public Post selectById(Integer id) {
        return postMapper.selectById(id);
    }

    public void updateById(Post post) {
        postMapper.updateById(post);
    }

    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            postMapper.deleteById(id);
        }
    }

    public void add(Post post) {
        postMapper.insert(post);
    }

    public List<Post> selectByTopicId(Integer id) {
        return postMapper.selectByTopicId(id);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        postMapper.deleteById(id);
    }

    /**
     * 分页查询
     */
    public PageInfo<Post> selectPage(Integer id,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Post> list = postMapper.selectByTopicId(id);
        return PageInfo.of(list);
    }
}
