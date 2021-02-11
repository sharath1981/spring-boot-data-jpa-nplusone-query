package com.datajpa.nplusone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datajpa.nplusone.domain.Comment;
import com.datajpa.nplusone.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
@RestController
public class CommentController {
	private final CommentRepository commentRepository;
	
	@GetMapping
	public List<Comment> list() {
		return commentRepository.findAll();
	}
	
	@PostMapping
	public Comment create(@RequestBody Comment comment) {
		return commentRepository.save(comment);
	}
}
