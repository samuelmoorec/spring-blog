package com.codeup.springblog.Repositories;

import com.codeup.springblog.Beans.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {



}
