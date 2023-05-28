package dev.easyi18n.dao;

import dev.easyi18n.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author meihang
 * @date 2023/5/28 22:27
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */

@Mapper
public interface UserDao {
    public int create(User user);

    public User getUserById(@Param("id") Long id);
}
