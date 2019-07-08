package com.codeup.springblog.Repositories;

import com.codeup.springblog.Beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    User findByUsername(String username);
}
