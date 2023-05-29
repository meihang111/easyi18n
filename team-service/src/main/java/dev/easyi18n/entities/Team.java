package dev.easyi18n.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author meihang
 * @date 2023/5/29 10:01
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long teamId;
    private String teamName;
    private Long teamOwner;
    private String teamDisc;
}
