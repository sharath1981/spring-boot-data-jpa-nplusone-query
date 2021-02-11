package com.datajpa.nplusone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datajpa.nplusone.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	//solution for N+1 query issue - join fetch required on child
	@Query("select comment from Comment comment join fetch comment.post")
	List<Comment> findAll();
	/* or
	@EntityGraph(attributePaths = {"post"}) 
	List<Comment> findAll();
	*/
}
