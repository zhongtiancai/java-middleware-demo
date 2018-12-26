package cn.frontpay.fos.dubbo.repository.base;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

/**
 * 数据访问抽象接口
 */
public interface IBaseRepository<T extends DomainBase>  extends BaseSelectMapper<T>, InsertMapper<T>, BaseUpdateMapper<T>,
	BaseDeleteMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>, Marker {
	
	

}
