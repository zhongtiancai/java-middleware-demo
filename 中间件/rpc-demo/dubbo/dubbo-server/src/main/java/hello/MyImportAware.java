package hello;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportAware implements ImportAware{

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println("");
		
	}

}
