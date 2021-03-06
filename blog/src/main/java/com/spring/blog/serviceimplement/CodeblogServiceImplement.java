package com.spring.blog.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.model.Post;
import com.spring.blog.repository.CodeblogRepository;
import com.spring.blog.services.CodeblogService;

@Service 
public class CodeblogServiceImplement implements CodeblogService{

	@Autowired
	CodeblogRepository codeblogRepository;

	
	@Override
	public List<Post> findAll() {
		return codeblogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogRepository.save(post);
	}

}
