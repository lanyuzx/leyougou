package com.leyougou.item.service;

import cn.leyougou.item.pojo.LLCategory;
import com.leyougou.item.mapper.LLCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class LLCategoryService {
    @Autowired
    private LLCategoryMapper categoryMapper;

    public List<LLCategory> categoryListByPid(Long pid) {

        LLCategory category = new LLCategory();
        category.setParent_id(pid);
        List<LLCategory> categoryList =  categoryMapper.select(category);
        if (CollectionUtils.isEmpty(categoryList)) {

        }
        return  categoryList;
    }
}
