package com.example.service;

import com.example.entity.Type;
import com.example.entity.Typeset;
import com.example.mapper.TypesetMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypesetService {

    @Resource
    private TypesetMapper typesetMapper;

    public List<Typeset> selectAll() {
        return typesetMapper.getTypesetMapList();
    }

    /**
     * 新增
     */
    public void add(Typeset typeset) {
        typesetMapper.insert(typeset);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        typesetMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            typesetMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Typeset typeset) {
        typesetMapper.updateById(typeset);
    }

    /**
     * 分页查询
     */
    public PageInfo<Typeset> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Typeset> list = typesetMapper.getTypesetMapList();
        return PageInfo.of(list);
    }
}
