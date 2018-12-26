package cn.frontpay.fos.dubbo.support.utils.mapper;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Converter {

	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml, Class<T> clazz) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (T) unmarshaller.unmarshal(new StringReader(xml));
	}
	
	public static String beanToXml(Object bean) throws JAXBException {
		return Converter.beanToXml(bean, "UTF-8");
	}
	
	public static String beanToXml(Object bean, String encoding) throws JAXBException {
		if (bean == null) {
			return "";
		}
		
		JAXBContext context = JAXBContext.newInstance(bean.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(bean, writer);
		return writer.toString();
	}

}
