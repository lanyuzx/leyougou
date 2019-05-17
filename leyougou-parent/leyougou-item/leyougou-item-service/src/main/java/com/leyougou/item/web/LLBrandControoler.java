package com.leyougou.item.web;

import cn.leyougou.item.pojo.LLBrand;
import com.leyougou.common.utils.LLPageResult;
import com.leyougou.item.service.LLBrandService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("brand")
public class LLBrandControoler {
    @Autowired
    private LLBrandService brandService;

    @GetMapping("page")
    public ResponseEntity<LLPageResult<LLBrand>> findBrandList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                                        @RequestParam(value = "sortBy", required = false) String sortBy,
                                        @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
                                        @RequestParam(value = "key", required = false) String key) {
      LLPageResult<LLBrand> pageResult = brandService.findBrand(page, rows, sortBy, desc, key);
      if (pageResult == null && CollectionUtils.isEmpty(pageResult.getItems())){
          return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).build();
      }
        return ResponseEntity.ok(pageResult);
    }
}
