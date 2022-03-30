package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.entity.VaccineEntity;
import com.lemon.service.MPVaccineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ws
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/vaccine")
@Api(value = "疫苗管理", tags = "疫苗信息管理API")
public class VaccineController {

    @Autowired
    private MPVaccineService mpVaccineService;

    @RequestMapping("/getAll")
    @ApiOperation(value = "获取疫苗列表")
    public JSONObject getVList(){
        List<VaccineEntity> vList = mpVaccineService.list();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vList", vList);
        return jsonObject;
    }

    @RequestMapping("/add")
    @ApiOperation(value = "通过疫苗信息添加",notes = "传入疫苗的基本信息")
    public JSONObject addVaccine(VaccineEntity vaccine) {
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

    @RequestMapping("/getInfo")
    @ApiOperation(value = "通过id查询", notes = "传入疫苗id")
    public JSONObject getById(@RequestParam Integer id) {
        VaccineEntity vaccine = mpVaccineService.getById(id);
        JSONObject jsonObject = new JSONObject();
        if (vaccine != null) {
            jsonObject.put("vaccineInfo", vaccine);
            jsonObject.put("result", "success");
        } else {
            jsonObject.put("result", "false");
        }
        return jsonObject;
    }

    @RequestMapping("/update")
    @ApiOperation(value = "修改疫苗信息")
    public void updateInfo(VaccineEntity vaccine){
        mpVaccineService.updateById(vaccine);
    }


}
