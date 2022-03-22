package com.lemon.service.impl;

import com.lemon.entity.VaccinationDetailsEntity;
import com.lemon.dao.IVaccinationDetailsDao;
import com.lemon.service.MPVaccinationDetailsService;
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
public class VaccinationDetailsServiceImpl extends ServiceImpl<IVaccinationDetailsDao, VaccinationDetailsEntity> implements MPVaccinationDetailsService {

}
