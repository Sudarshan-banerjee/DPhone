package com.dphone.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dphone.user.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{

}
