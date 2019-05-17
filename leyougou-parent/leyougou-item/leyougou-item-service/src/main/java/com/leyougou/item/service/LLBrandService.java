package com.leyougou.item.service;

import cn.leyougou.item.pojo.LLBrand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyougou.common.utils.LLPageResult;
import com.leyougou.item.mapper.LLBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;


@Service
public class LLBrandService {
    @Autowired
    private LLBrandMapper brandMapper;
   public LLPageResult<LLBrand> findBrand(Integer page, Integer rows,String sortKey,Boolean desc,String key) {
        PageHelper.startPage(page, rows);
       Example example = new Example(LLBrand.class);
       if (!StringUtils.isEmpty(key)) {
           example.createCriteria().andLike("name" + "%", key + "%").orEqualTo("letter", key);
       }
       if (!StringUtils.isEmpty(sortKey)) {
           example.setOrderByClause(sortKey + (desc ? " desc " : " asc "));
       }

        Page<LLBrand> brandPage = (Page<LLBrand>) brandMapper.selectByExample(example);

       return new LLPageResult<>(brandPage.getTotal(), brandPage.getResult());
    }

}
