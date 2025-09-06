package com.ai.text.analytics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.text.analytics.model.TextData;
import com.ai.text.analytics.service.TextService;

@RestController
@RequestMapping("/api/text")
public class TextController {
	private final TextService service;

	public TextController(TextService service) {
		this.service = service;
	}

	@GetMapping
	public List<TextData> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public TextData getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@PostMapping
	public TextData create(@RequestBody TextData data) {
		return service.create(data);
	}

	@PutMapping("/{id}")
	public TextData update(@PathVariable Long id, @RequestBody TextData data) {
		return service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}