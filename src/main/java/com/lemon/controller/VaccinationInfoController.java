package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.entity.VaccinationInfoEntity;
import com.lemon.service.MPVaccinationInfoService;
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
@RequestMapping("/vi/info")
@Api(value = "疫苗接种管理", tags = "疫苗接种管理API")
public class VaccinationInfoController {

    @Autowired
    private MPVaccinationInfoService mpVaccinationInfoService;

    @RequestMapping("/getAll")
    @ApiOperation(value = "获取疫苗接种地情况列表")
    public JSONObject getViList(){
        List<VaccinationInfoEntity> viList = mpVaccinationInfoService.list();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("viList", viList);
        return jsonObject;
    }


}
