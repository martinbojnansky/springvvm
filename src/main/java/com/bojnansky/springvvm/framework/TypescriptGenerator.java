package com.bojnansky.springvvm.framework;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import com.blueveery.springrest2ts.Rest2tsGenerator;
import com.blueveery.springrest2ts.converters.JacksonObjectMapper;
import com.blueveery.springrest2ts.converters.ModelClassesToTsInterfacesConverter;
import com.blueveery.springrest2ts.converters.SpringRestToTsConverter;
import com.blueveery.springrest2ts.filters.ExtendsJavaTypeFilter;
import com.blueveery.springrest2ts.implgens.Angular4ImplementationGenerator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class TypescriptGenerator implements Generator {
	public void run(List<String> javaPackageNames) throws IOException {
		Rest2tsGenerator tsGenerator = new Rest2tsGenerator();
	    
	    // Java Classes filtering
	    tsGenerator.setModelClassesCondition(new ExtendsJavaTypeFilter(Model.class));
	    tsGenerator.setRestClassesCondition(new ExtendsJavaTypeFilter(ViewModel.class));
	    
	    // Java model classes converter setup
	    JacksonObjectMapper jacksonObjectMapper = new JacksonObjectMapper();
	    jacksonObjectMapper.setFieldsVisibility(JsonAutoDetect.Visibility.ANY);
	    var modelClassesConverter = new ModelClassesToTsInterfacesConverter(jacksonObjectMapper);
	    tsGenerator.setModelClassesConverter(modelClassesConverter);
	    
	    // Spring REST controllers converter
	    var restClassesConverter = new SpringRestToTsConverter(new Angular4ImplementationGenerator());
	    tsGenerator.setRestClassesConverter(restClassesConverter);
	    
	    // set of java root packages for class scanning
	    for(var i = 0; i < javaPackageNames.size(); i++) {
	    	String name = javaPackageNames.get(i);
	    	var javaPackageSet = Collections.singleton("com.bojnansky.springvvm." + name);
	    	tsGenerator.generate(javaPackageSet, Paths.get("frontend/src/app/" + name + "/api"));
	    }

	}
}
