package cn.frontpay.fos.dubbo.service.manage.spe;

import cn.frontpay.fos.dubbo.service.manage.spe.dto.SysConfigDto;

public interface ISysConfigService {

	SysConfigDto findByCode(String code);

}
