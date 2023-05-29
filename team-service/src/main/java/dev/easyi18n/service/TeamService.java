package dev.easyi18n.service;

import dev.easyi18n.entities.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author meihang
 * @date 2023/5/28 21:27
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
public interface TeamService {
    public int createTeam(Team team);

    public Team getTeamByTeamId(@Param("teamId") Long teamId);

    public List<Team> getTeamByUserId(@Param("userId") Long userId);
}
