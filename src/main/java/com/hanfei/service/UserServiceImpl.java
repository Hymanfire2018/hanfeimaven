
package com.hanfei.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hanfei.dao.UserDao;
import com.hanfei.domain.User;
 
@Service  
public class UserServiceImpl implements UserService {
 
    @Autowired  
    private UserDao userDao;  
 
    public User selectUserById(Integer userId) {  
        return userDao.selectUserById(userId);  
 
    }  
}