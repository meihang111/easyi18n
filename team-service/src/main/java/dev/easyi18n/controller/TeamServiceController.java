package dev.easyi18n.controller;

import com.alibaba.fastjson.JSONObject;
import dev.easyi18n.entities.CommonResult;
import dev.easyi18n.entities.Team;
import dev.easyi18n.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author meihang
 * @date 2023/5/29 17:58
 * @project https://github.com/meihang111/easyi18n
 */
@RestController
@Slf4j
public class TeamServiceController {
    @Resource
    TeamService teamService;

    @PostMapping(value="team/create")
    public CommonResult create(Team team){
        int result = teamService.createTeam(team);
        log.info("******插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"teamcreateSuccess",result);
        }else {
            return new CommonResult(200,"teamcreateError",null);
        }
    };

    @GetMapping(value="team/getbyteamid/{teamId}")
    public CommonResult getByTeamId(@PathVariable("teamId") Long teamId){
        JSONObject team = teamService.getTeamByTeamId(teamId);
        if(team != null){
            return new CommonResult(200,"teamsearchSuccess",team);
        }else {
            return new CommonResult(200,"teamsearchError",null);
        }
    };

    @GetMapping(value = "team/getbyuserid/{userId}")
    public CommonResult getByUserId(@PathVariable("userId") Long userId){
        List<Team> teamList = teamService.getTeamByUserId(userId);
        if(teamList != null){
            return new CommonResult(200,"teamsearchSuccess",teamList);
        }else {
            return new CommonResult(200,"teamsearchError",null);
        }
    };
}
