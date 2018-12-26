package cn.frontpay.fos.dubbo.repository.base;

import java.io.Serializable;

import cn.frontpay.fos.dubbo.support.utils.mapper.AutoMapper;

/**
 * 数据库实体基类
 */
public abstract class DomainBase implements Serializable {

	private static final long serialVersionUID = 1L;

	public <T> T convertTo(Class<T> destinationType){
		return AutoMapper.map(this, destinationType);
	}
}
