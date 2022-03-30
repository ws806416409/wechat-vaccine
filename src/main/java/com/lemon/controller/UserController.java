package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.entity.UserEntity;
import com.lemon.entity.UserInfoEntity;
import com.lemon.service.MPUserInfoService;
import com.lemon.service.MPUserService;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nxq
 * @since 2022-03-22
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = "Swagger测试用户管理API")
public class UserController {

    @Autowired
    private MPUserService mpUserService;

    @Autowired
    private MPUserInfoService mpUserInfoService;

    @GetMapping("/login")
    @ApiOperation(value = "用户登录",notes = "判断用户名密码登录")
    public Object login(String username, String password){
        QueryWrapper<UserEntity> qu = new QueryWrapper<>();
        qu.eq("username",username);
        qu.eq("password",password);

        UserEntity us = mpUserService.getOne(qu);

        JSONObject jsonObject = new JSONObject();
        if (us != null) {
            jsonObject.put("UserId", us.getUid());
            if(us.getPermission() == 1){
                jsonObject.put("msg","管理员");
            }
            else {
                jsonObject.put("msg","普通用户");
            }
        }
        else {
            jsonObject.put("UserId", -1);
        }
        return jsonObject;
    }


    @GetMapping("/register")
    @ApiOperation(value = "注册账号",notes = "判断用户名是否存在，进行注册操作")
    public Object register(@RequestParam("username") String username, @RequestParam("password") String password) {

        JSONObject jsonObject = new JSONObject();
        QueryWrapper<UserEntity> qu = new QueryWrapper<>();

        UserEntity us = new UserEntity();


        us.setUsername(username);
        us.setPassword(password);
        us.setUid(null);
        us.setPermission(0);

        qu.eq("username",username);
        UserEntity us1 = mpUserService.getOne(qu);

        if (us1 != null){
            jsonObject.put("msg","注册失败,用户名已存在");
            return jsonObject;
        }
        if(username.contains(" ") || password.contains(" ") || StringUtils.isEmptyOrWhitespaceOnly(username) ||StringUtils.isEmptyOrWhitespaceOnly(password)) {
            jsonObject.put("msg","注册失败,输入不合法");
        }
        else{
            mpUserService.save(us);
            UserInfoEntity ue = new UserInfoEntity();
            ue.setId(null);
            ue.setUid(us.getUid());
            ue.setRealName(null);
            ue.setIdCard(null);
            ue.setPhone(null);
            ue.setGender(null);
            ue.setAge(null);
            ue.setAllergy(null);
            ue.setAdverseReaction(null);
            mpUserInfoService.save(ue);
            jsonObject.put("msg","注册成功");
        }
        return jsonObject;
    }

    @RequestMapping("/delete")
    public void removeById(Integer id){
        mpUserService.removeById(id);
    }
}
