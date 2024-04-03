package com.graphQl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphQl.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
