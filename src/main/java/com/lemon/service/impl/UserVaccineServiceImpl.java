package com.lemon.service.impl;

import com.lemon.entity.UserVaccineEntity;
import com.lemon.dao.IUserVaccineDao;
import com.lemon.service.MPUserVaccineService;
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
public class UserVaccineServiceImpl extends ServiceImpl<IUserVaccineDao, UserVaccineEntity> implements MPUserVaccineService {

}
