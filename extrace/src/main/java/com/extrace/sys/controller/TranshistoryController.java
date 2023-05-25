package com.extrace.sys.controller;


import com.extrace.common.vo.Result;
import com.extrace.sys.mapper.TranshistoryMapper;
import com.extrace.sys.mapper.TransnodeMapper;
import com.extrace.sys.mapper.TranspackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

public class TranshistoryController {
    @Autowired
    private TranshistoryMapper transhistoryMapper;


    @Autowired
    private TransnodeMapper transNodeMapper;


    public TranshistoryController(TranshistoryMapper transhistoryMapper) {
        this.transhistoryMapper = transhistoryMapper;
    }

    @GetMapping("/test4")
    public Result<List<Map<String, Object>>> getAllTranshistory() {

        return  Result.success(transhistoryMapper.getAllTranshistory()); //
    }

}

