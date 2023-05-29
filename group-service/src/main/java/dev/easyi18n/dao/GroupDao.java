package dev.easyi18n.dao;

import dev.easyi18n.entities.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author meihang
 * @date 2023/5/29 10:34
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@Mapper
public interface GroupDao {
    public int create(Group group);

    public Group getGroupById(@Param("groupId") Long groupId);
}
