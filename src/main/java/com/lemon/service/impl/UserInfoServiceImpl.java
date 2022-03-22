package com.lemon.service.impl;

import com.lemon.entity.UserInfoEntity;
import com.lemon.dao.IUserInfoDao;
import com.lemon.service.MPUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemon
 * @since 2022-03-22
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<IUserInfoDao, UserInfoEntity> implements MPUserInfoService {

}
