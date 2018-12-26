package cn.frontpay.fos.dubbo.service.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.frontpay.fos.dubbo.repository.manage.dao.SysConfigRepository;
import cn.frontpay.fos.dubbo.repository.manage.entity.SysConfigEntity;
import cn.frontpay.fos.dubbo.repository.manage.entity.SysConfigEntityExample;
import cn.frontpay.fos.dubbo.service.manage.spe.ISysConfigService;
import cn.frontpay.fos.dubbo.service.manage.spe.dto.SysConfigDto;

public class SysConfigService implements ISysConfigService {

	@Autowired
	private SysConfigRepository sysConfigRepository;
	
	@Override
	public SysConfigDto findByCode(String code) {
		SysConfigEntityExample example = new SysConfigEntityExample();
		example.createCriteria().andCodeEqualTo(code).andIsDeleteEqualTo(false);
		List<SysConfigEntity> entitys = sysConfigRepository.selectByExample(example);
		if (entitys == null || entitys.size() == 0) {
			return null;
		}
		return entitys.get(0).convertTo(SysConfigDto.class);
	}

}
