package com.lemon.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.dao.IUserDao;
import com.lemon.entity.UserEntity;
import com.lemon.service.MPUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/user")
@Api(value = "用户管理", tags = "Swagger测试用户管理API")
public class UserController {

    @Autowired
    private MPUserService mpUserService;

    @PostMapping("/login")
    public Object login(String username, String password){
        QueryWrapper<UserEntity> qu = new QueryWrapper<>();
        qu.eq("username",username);
        qu.eq("password",password);
        UserEntity us = mpUserService.getOne(qu);
        JSONObject jsonObject = new JSONObject();
        if (us != null) {
            jsonObject.put("UserId", us.getUid());
        } else {
            jsonObject.put("UserId", -1);
        }
        return jsonObject;
    }

}
