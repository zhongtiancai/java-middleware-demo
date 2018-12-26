package cn.frontpay.fos.dubbo.repository.base;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;


public class InsertProvider extends MapperTemplate {
	public InsertProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}

	public String insert(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);

		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.insertIntoTable(entityClass,
				tableName(entityClass)));
		sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
		sql.append(SqlHelper.insertValuesColumns(entityClass, false, false,
				false));
		return sql.toString();
	}

	public String insertSelective(MappedStatement ms) {
		Class<?> entityClass = getEntityClass(ms);
		StringBuilder sql = new StringBuilder();
		sql.append(SqlHelper.insertIntoTable(entityClass,
				tableName(entityClass)));
		sql.append(SqlHelper.insertColumns(entityClass, false, true,
				isNotEmpty()));
		sql.append(SqlHelper.insertValuesColumns(entityClass, false, true,
				isNotEmpty()));
		return sql.toString();
	}
}