package com.lemon.service.impl;

import com.lemon.entity.UserEntity;
import com.lemon.dao.IUserDao;
import com.lemon.service.MPUserService;
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
public class UserServiceImpl extends ServiceImpl<IUserDao, UserEntity> implements MPUserService {

}
