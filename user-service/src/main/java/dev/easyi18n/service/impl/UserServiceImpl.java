package dev.easyi18n.service.impl;

import dev.easyi18n.dao.UserDao;
import dev.easyi18n.entities.User;
import dev.easyi18n.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author meihang
 * @date 2023/5/29 8:42
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public int create(User user){
        return userDao.create(user);
    };

    public User getUserById(@Param("id") Long id){
        return userDao.getUserById(id);
    };
}
