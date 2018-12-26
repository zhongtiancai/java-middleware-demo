package cn.frontpay.fos.dubbo.support.utils.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 * 实体转换器
 * 
 * @param <D>
 */
public final class AutoMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	static {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * @param source
	 *            源对象
	 * @param destinationType
	 *            目标类型
	 * @return 目标对象
	 */
	public static <D> D map(Object source, Class<D> destinationType) {
        if(source==null) return null;
		return modelMapper.map(source, destinationType);
	}
	
	public static void map(Object source, Object destination) {

		modelMapper.map(source, destination);
	}

	public static <E, D> List<D> mapList(List<E> source, Class<D> destinationType) {

		if (source == null)
			return null;

		List<D> targetList = new ArrayList<D>(source.size());

		for (E item : source) {

			D target = modelMapper.map(item, destinationType);

			targetList.add(target);
		}

		return targetList;
	}

	public static <E, D> Collection<D> mapCollection(Collection<E> source, Class<D> destinationType) {
		if (source == null)
			return null;
		
		Collection<D> retList = null;
		
		if (source instanceof List) {
			retList = new ArrayList<D>(source.size());
		} else if(source instanceof Set){
			retList = new HashSet<D>(); 
		}
		for (E item : source) {

			D target = modelMapper.map(item, destinationType);

			retList.add(target);
		}

		return retList;
	}

}
