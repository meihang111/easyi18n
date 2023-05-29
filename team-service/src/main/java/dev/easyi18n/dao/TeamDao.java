package dev.easyi18n.dao;

import dev.easyi18n.entities.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author meihang
 * @date 2023/5/29 10:34
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@Mapper
public interface TeamDao {
    public int createTeam(Team team);

    public Team getTeamByTeamId(@Param("teamId") Long teamId);

    public List<Team> getTeamByUserId(@Param("userId") Long userId);

//    public List<Long> getUserByTeamId(@Param("teamId") Long teamId);
//
//    public int addMenbers(Long teamId, List<Long> userIds);
}
