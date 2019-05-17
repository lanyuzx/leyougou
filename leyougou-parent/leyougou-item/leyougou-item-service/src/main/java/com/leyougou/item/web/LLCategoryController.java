package com.leyougou.item.web;

import cn.leyougou.item.pojo.LLCategory;
import com.leyougou.item.service.LLCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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
    public ResponseEntity<List<LLCategory>> categoryListByPid(@RequestParam(value = "pid" ,defaultValue = "0") Long pid) {
        try {
            if (pid == null  || pid.longValue() < 0) {
                //响应400
                return ResponseEntity.badRequest().build();
            }
            List<LLCategory> categoryList = categoryService.categoryListByPid(pid);
            if (CollectionUtils.isEmpty(categoryList)) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(categoryList);
        }catch (Exception e) {
            e.printStackTrace();
        }
        //响应 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
