package com.bojnansky.springvvm.simple;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bojnansky.springvvm.framework.ViewModel;

@RestController
@RequestMapping("/api/simple")
public class SimpleViewModel implements ViewModel<SimpleModel> {
	private SimpleModel model = new SimpleModel();
	
	@GetMapping()
	@ResponseBody
	public ResponseEntity<SimpleModel> get() {	
		this.model.setName("World");
		return ResponseEntity.ok().body(this.model);
	}
	
	@PostMapping()
	@ResponseBody
	public ResponseEntity<SimpleModel> post(@RequestBody SimpleModel model) throws Exception {	
		this.validateModel(model);
		this.model = model;
		return ResponseEntity.ok().body(this.model);
	}
	
	public void validateModel(SimpleModel model) throws Exception {
		if(model.getName().contains("x")) {
			throw new Exception("Name cannot contain: x");
		}
	}
	
}
