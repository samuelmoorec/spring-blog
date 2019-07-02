package com.codeup.springblog.Repositories;

import com.codeup.springblog.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
}
