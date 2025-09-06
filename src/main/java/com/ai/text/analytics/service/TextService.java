package com.ai.text.analytics.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ai.text.analytics.model.TextData;
import com.ai.text.analytics.repository.TextRepository;

@Service
public class TextService {
	private final TextRepository repo;
	private final RestTemplate restTemplate = new RestTemplate();

	public TextService(TextRepository repo) {
		this.repo = repo;
	}

	public List<TextData> getAll() {
		return repo.findAll();
	}

	public TextData getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public TextData create(TextData textData) {
		Map<String, String> payload = Map.of("text", textData.getText());
		Map<String, Object> result = restTemplate.postForObject("http://localhost:5001/analyze", payload, Map.class);
		textData.setWordCount((int) result.get("word_count"));
		textData.setSentiment(Double.parseDouble(result.get("sentiment").toString()));
		return repo.save(textData);
	}

	public TextData update(Long id, TextData textData) {
		TextData existing = getById(id);
		if (existing == null)
			return null;

		existing.setText(textData.getText());
		return create(existing); // Re-analyze
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}