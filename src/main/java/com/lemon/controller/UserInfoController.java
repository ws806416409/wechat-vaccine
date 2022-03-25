package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.entity.UserEntity;
import com.lemon.entity.UserInfoEntity;
import com.lemon.service.MPUserInfoService;
import com.lemon.service.MPUserService;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nxq
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/user/info")
public class UserInfoController {

    @Autowired
    private MPUserInfoService mpUserInfoService;

    @Autowired
    private MPUserService mpUserService;


    @RequestMapping("/getByUid")
    @ApiOperation(value = "查看个人详细信息")
    public JSONObject getInfo(@RequestParam("uid") Integer uid){

        QueryWrapper<UserInfoEntity> qu = new QueryWrapper<>();
        qu.eq("uid",uid);
        JSONObject jsonObject = new JSONObject();

        //传入uid不存在
        if(mpUserInfoService.getOne(qu)==null||mpUserService.getById(uid)==null)
        {
            jsonObject.put("msg","uid不存在");
            return jsonObject;
        }

        UserInfoEntity us = mpUserInfoService.getOne(qu);
        UserEntity us1 = mpUserService.getById(uid);
        jsonObject.put("username",us1.getUsername());
        jsonObject.put("us",us);
        return jsonObject;
    }

    @RequestMapping("/update")
    @ApiOperation(value = "修改个人基本信息")
    public void updateUserInfo(UserInfoEntity us){
        QueryWrapper<UserInfoEntity> qu = new QueryWrapper<>();
        qu.eq("uid",us.getUid());

        this.mpUserInfoService.update(us,qu);
    }

    @RequestMapping("/updatePassword")
    @ApiOperation(value = "修改密码",tags = "更改登录密码")
    public JSONObject updatePassword(@RequestParam("username") String username,@RequestParam("password") String password){
        QueryWrapper<UserEntity> qu =new QueryWrapper<>();
        JSONObject jsonObject = new JSONObject();
        qu.eq("username",username);
        UserEntity userEntity = mpUserService.getOne(qu);
        userEntity.setPassword(password);
        if (userEntity.getPassword().contains(" ")|| StringUtils.isEmptyOrWhitespaceOnly(userEntity.getPassword()))
        {
            jsonObject.put("msg","输入非法,修改失败");
            return jsonObject;
        }
        this.mpUserService.update(userEntity,qu);
        jsonObject.put("msg","修改成功");
        return jsonObject;
    }
}
