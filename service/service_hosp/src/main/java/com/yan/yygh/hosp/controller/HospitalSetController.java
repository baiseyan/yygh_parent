package com.yan.yygh.hosp.controller;

import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.yan.yygh.hosp.service.HospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Autowired
    private HospitalSetService hospitalSetService;

    //1 查询医院设置表所有信息
    @ApiOperation(value = "获取所有医院设置")
    @GetMapping("findAll")
    public Result findAllHospitalSet(){
        List<HospitalSet> hospitalSets = hospitalSetService.list();
        return Result.ok(hospitalSets);
    }

    //2 逻辑删除医院设置
    @ApiOperation(value = "根据逻辑ID删除医院设置")
    @DeleteMapping("{id}")
    public Result removeHospitalSet(@PathVariable long id){
        boolean flag = hospitalSetService.removeById(id);
        if(flag){
            return Result.ok();
        }
            return Result.fail();
    }

}
