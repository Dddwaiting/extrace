package com.extrace.sys.controller;


import com.extrace.common.vo.Result;
import com.extrace.sys.mapper.TransnodeMapper;
import com.extrace.sys.mapper.TranspackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author
 * @since 2023-05-16
 */
@RestController

public class TranspackageController {



    @Autowired
    private TranspackageMapper transpackageMapper;


    @Autowired
    private TransnodeMapper transNodeMapper;


    public TranspackageController(TranspackageMapper transPackageMapper) {
        this.transpackageMapper = transPackageMapper;
    }

    @GetMapping("/test3")
    public Result<List<Map<String, Object>>> getAllTransPackages() {

        return  Result.success(transpackageMapper.getAllTransPackages()); //
    }
}




