package dev.easyi18n.service.impl;

import dev.easyi18n.dao.TeamDao;
import dev.easyi18n.entities.Team;
import dev.easyi18n.service.TeamService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author meihang
 * @date 2023/5/29 8:42
 * @email 1769881764@qq.com
 * @project https://github.com/meihang111/easyi18n
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamDao teamDao;

    public int createTeam(Team team){
        return teamDao.createTeam(team);
    };

    public Team getTeamByTeamId(@Param("teamId") Long teamId){
        return teamDao.getTeamByTeamId(teamId);
    };

    public List<Team> getTeamByUserId(@Param("userId") Long userId){
        return teamDao.getTeamByUserId(userId);
    };
}
