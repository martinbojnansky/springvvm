package com.bojnansky.springvvm;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bojnansky.springvvm.framework.Generator;
import com.bojnansky.springvvm.framework.TypescriptGenerator;

@SpringBootApplication
public class SpringvvmApplication {

	public static void main(String[] args) throws IOException {
		Generator tsGenerator = new TypescriptGenerator();
		tsGenerator.run(Arrays.asList("simple"));
		SpringApplication.run(SpringvvmApplication.class, args);
	}
}
