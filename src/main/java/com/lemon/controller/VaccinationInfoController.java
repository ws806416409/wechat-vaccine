package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.entity.VaccinationInfoEntity;
import com.lemon.entity.VaccineEntity;
import com.lemon.service.MPVaccinationInfoService;
import com.lemon.service.MPVaccineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@Api(value = "疫苗接种地管理", tags = "疫苗接种管理API")
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

    @RequestMapping("/validInfo")
    @ApiOperation("获取有效预约信息")
    public JSONObject selectByDose(@RequestParam("vid") Integer vid){
        QueryWrapper<VaccinationInfoEntity> qu = new QueryWrapper<>();
        qu.ge("dose", 1);
        qu.eq("vid", vid);
        List<VaccinationInfoEntity> viList = mpVaccinationInfoService.list(qu);
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
    @ApiOperation(value = "增加接种地信息", notes = "传入vaccination_id, vaccination_place, vaccination_open_time, vaccine_dose")
    public void addInfo(@RequestParam("vid") Integer vid,
                        @RequestParam("place") String place,
                        @RequestParam("vtime") String time,
                        @RequestParam("dose") Integer dose,
                        @RequestParam("rank") Integer rank){
        VaccinationInfoEntity vaccinationInfo = new VaccinationInfoEntity();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime vTime = LocalDateTime.parse(time, dateTimeFormatter);
        vaccinationInfo.setVid(vid);
        vaccinationInfo.setPlace(place);
        vaccinationInfo.setVtime(vTime);
        vaccinationInfo.setDose(dose);
        vaccinationInfo.setRank(rank);
        vaccinationInfo.setId(null);
        mpVaccinationInfoService.save(vaccinationInfo);

    }

    @RequestMapping("/update")
    @ApiOperation(value = "修改接种地信息")
    public void updateInfo(VaccinationInfoEntity vaccinationInfo){
        mpVaccinationInfoService.updateById(vaccinationInfo);
    }

    @RequestMapping("/find")
    public JSONObject findById(Integer id){
        VaccinationInfoEntity info = mpVaccinationInfoService.getById(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vnInfo", info);
        return jsonObject;
    }

}
