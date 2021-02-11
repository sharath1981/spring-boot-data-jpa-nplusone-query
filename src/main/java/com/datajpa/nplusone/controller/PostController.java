package com.datajpa.nplusone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datajpa.nplusone.domain.Post;
import com.datajpa.nplusone.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
@RestController
public class PostController {
	private final PostRepository postRepository;
	
	@GetMapping
	public List<Post> list() {
		return postRepository.findAll();
	}
	
	@PostMapping
	public Post create(@RequestBody Post post) {
		return postRepository.save(post);
	}

}
