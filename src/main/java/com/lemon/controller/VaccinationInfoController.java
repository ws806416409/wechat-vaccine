package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.entity.VaccinationInfoEntity;
import com.lemon.service.MPVaccinationInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.time.LocalDateTime;
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

    @RequestMapping("/delete")
    @ApiOperation(value = "通过id删除接种地信息")
    public void deleteById(@RequestParam Integer id){
        mpVaccinationInfoService.removeById(id);
    }

    @RequestMapping("/add")
    @ApiOperation(value = "增加接种地信息")
    public void addInfo(@RequestParam("vaccination_id") Integer vid,
                        @RequestParam("vaccination_place") String place,
                        @RequestParam("vaccination_open_time") LocalDateTime vtime,
                        @RequestParam("vaccine_dose") Integer dose){
        VaccinationInfoEntity vaccinationInfo = new VaccinationInfoEntity();
        vaccinationInfo.setVid(vid);
        vaccinationInfo.setPlace(place);
        vaccinationInfo.setVtime(vtime);
        vaccinationInfo.setDose(dose);
        int rank = (int) mpVaccinationInfoService.count();
        rank += 1;
        vaccinationInfo.setRank(rank);
        mpVaccinationInfoService.save(vaccinationInfo);
    }

    @RequestMapping("/update")
    @ApiOperation(value = "修改接种地信息")
    public void updateInfo(VaccinationInfoEntity vaccinationInfo){
        mpVaccinationInfoService.updateById(vaccinationInfo);
    }

}
