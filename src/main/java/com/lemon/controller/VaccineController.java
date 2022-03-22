package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.entity.VaccineEntity;
import com.lemon.service.MPVaccineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemon
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    private MPVaccineService mpVaccineService;

    @RequestMapping("/add")
    @ApiOperation(value = "通过疫苗信息添加",notes = "传入疫苗的基本信息")
    public Object addVaccine(VaccineEntity vaccine) {
        JSONObject jsonObject = new JSONObject();
        if (vaccine != null) {
            mpVaccineService.save(vaccine);
            jsonObject.put("result", "success");
        } else {
            jsonObject.put("result", "false");
        }
        return jsonObject;
    }

    @RequestMapping("/remove")
    @ApiOperation(value = "通过id删除",notes = "传入疫苗的id")
    public void removeVaccine(@RequestParam Integer id) {
        mpVaccineService.removeById(id);
    }

}
