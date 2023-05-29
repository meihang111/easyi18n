package dev.easyi18n.service;

import dev.easyi18n.entities.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author meihang
 * @date 2023/5/28 21:27
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
public interface UserService {
    public int create(User user);

    public User getUserById(@Param("id") Long id);
}
