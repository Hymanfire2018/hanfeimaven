package com.hanfei.dao;
 
import com.hanfei.domain.User;
 
public interface UserDao {
 
    /**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId);  
 
}