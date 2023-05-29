package dev.easyi18n.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Vector;

/**
 * @author meihang
 * @date 2023/5/29 10:01
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
public class Group {
    @TableId(type = IdType.AUTO)
    private Long groupId;
    private String groupName;
    private Long groupOwner;
    private Vector<Long> groupMembers;
}
