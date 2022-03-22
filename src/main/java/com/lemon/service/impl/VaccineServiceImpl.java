package com.lemon.service.impl;

import com.lemon.entity.VaccineEntity;
import com.lemon.dao.IVaccineDao;
import com.lemon.service.MPVaccineService;
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
public class VaccineServiceImpl extends ServiceImpl<IVaccineDao, VaccineEntity> implements MPVaccineService {

}
