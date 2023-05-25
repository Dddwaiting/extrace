package com.extrace.sys.controller;


import com.extrace.common.vo.Result;


import com.extrace.sys.entity.Expresssheet;
import com.extrace.sys.mapper.ExpresssheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@RestController

public class ExpresssheetController {
    @Autowired
    private ExpresssheetMapper expresssheetMapper;
    @GetMapping("/test1")
    public Result<List<Expresssheet>> getExpresssheet() {
        List<Expresssheet> List = expresssheetMapper.getExpresssheet();
        return  Result.success(List); //
    }
}

