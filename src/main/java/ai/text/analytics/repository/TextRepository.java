package ai.text.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.text.analytics.model.TextData;
public interface TextRepository extends JpaRepository<TextData, Long> {
}