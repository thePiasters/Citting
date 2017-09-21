package com.citting.repositories;

import com.citting.entity.User;
import com.citting.entity.UserPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByEmailOrLogin(String email, String login);
    User findUserByEmailAndLogin(String email, String login);


}
