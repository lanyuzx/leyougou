package com.leyougou.item.web;

import cn.leyougou.item.pojo.LLCategory;
import com.leyougou.item.service.LLCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class LLCategoryController {
    @Autowired
    private LLCategoryService categoryService;

    @GetMapping("list")
    public List<LLCategory> categoryListByPid(@RequestParam("pid") Long pid) {

        return categoryService.categoryListByPid(pid);
    }
}
