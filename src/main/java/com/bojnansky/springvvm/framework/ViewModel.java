package com.bojnansky.springvvm.framework;

import org.springframework.http.ResponseEntity;

public interface ViewModel<T> {
	ResponseEntity<T> get();
	void validateModel(T model) throws Exception;
}
