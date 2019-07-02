package com.codeup.springblog.Repositories;

import com.codeup.springblog.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {



}
