package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.entity.VaccinationDetailsEntity;
import com.lemon.service.MPVaccinationDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemon
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/vn/details")
@Api(value = "接种情况")
public class VaccinationDetailsController {

    @Autowired
    private MPVaccinationDetailsService mpVaccinationDetailsService;

    @RequestMapping("/getAll")
    @ApiOperation("获取接种情况列表")
    public JSONObject getVdList(){
        List<VaccinationDetailsEntity> vdList = mpVaccinationDetailsService.list();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vdList", vdList);
        return jsonObject;
    }

    @RequestMapping("add")
    @ApiOperation("添加接种情况")
    public JSONObject add(VaccinationDetailsEntity vd) {
        JSONObject jsonObject = new JSONObject();
        if (vd != null) {
            mpVaccinationDetailsService.save(vd);
            jsonObject.put("result", "success");
        } else {
            jsonObject.put("result", "false");
        }
        return jsonObject;
    }

}
