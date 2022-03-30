package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.entity.UserVaccinationInfoEntity;
import com.lemon.entity.UserVaccineEntity;
import com.lemon.entity.VaccinationInfoEntity;
import com.lemon.service.MPUserVaccinationInfoService;
import com.lemon.service.MPUserVaccineService;
import com.lemon.service.MPVaccinationInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ymx
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/user/vaccine")
public class UserVaccinationInfoController {

    @Autowired
    private MPUserVaccineService mpUserVaccineService;
    @Autowired
    private MPUserVaccinationInfoService mpUserVaccinationInfoService;
    @Autowired
    private MPVaccinationInfoService mpVaccinationInfoService;

    @RequestMapping("/add")
    @ApiOperation("用户预约")
    public void add(@RequestParam("uid")Integer uid, @RequestParam("vid")Integer vid, @RequestParam("viid")Integer viid) {
        UserVaccineEntity userVaccineEntity = new UserVaccineEntity();
        UserVaccinationInfoEntity userVaccinationInfoEntity = new UserVaccinationInfoEntity();
        userVaccineEntity.setUid(uid);
        userVaccineEntity.setVid(vid);
        userVaccinationInfoEntity.setViid(viid);
        mpUserVaccineService.save(userVaccineEntity);
        mpUserVaccinationInfoService.save(userVaccinationInfoEntity);

    }

    @RequestMapping("/getvcinfo")
    @ApiOperation("获取用户预约的所有信息")
    public JSONObject getVCinfo(@RequestParam("uid")Integer uid){
        QueryWrapper<UserVaccinationInfoEntity>qw = new QueryWrapper();
        qw.eq("uid",uid);
        List<UserVaccinationInfoEntity> userInfo = mpUserVaccinationInfoService.list(qw);
        List<VaccinationInfoEntity> list = new ArrayList<>();

        for(int i=0; i<userInfo.size(); i++){

            Integer viid = userInfo.get(i).getViid();
            QueryWrapper<VaccinationInfoEntity> qu = new QueryWrapper<>();
            qu.eq("id",viid);
            VaccinationInfoEntity info = mpVaccinationInfoService.getOne(qu);
            list.add(info);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("vnInfo", list);
        return jsonObject;
    }

}
