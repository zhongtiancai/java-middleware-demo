package cn.frontpay.fos.dubbo.service.base.dto;

import java.io.Serializable;

import cn.frontpay.fos.dubbo.support.utils.mapper.AutoMapper;

public abstract class DtoBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public <T> T convertTo(Class<T> destinationType){
		return AutoMapper.map(this, destinationType);
	}
}
