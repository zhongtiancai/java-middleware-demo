package cn.frontpay.fos.dubbo.repository.base;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

public abstract interface InsertMapper<T> {
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = InsertProvider.class, method = "dynamicSQL")
	public abstract int insert(T paramT);
	
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = InsertProvider.class, method = "dynamicSQL")
	public abstract int insertSelective(T paramT);
	
}