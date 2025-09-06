package com.ai.text.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.text.analytics.model.TextData;
public interface TextRepository extends JpaRepository<TextData, Long> {
}