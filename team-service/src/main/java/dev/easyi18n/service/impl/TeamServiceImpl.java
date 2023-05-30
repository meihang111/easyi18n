package dev.easyi18n.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dev.easyi18n.dao.TeamDao;
import dev.easyi18n.entities.Team;
import dev.easyi18n.service.TeamService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Resource
    private RestTemplate restTemplate;

    public int createTeam(Team team){
        return teamDao.createTeam(team);
    };

    public JSONObject getTeamByTeamId(@Param("teamId") Long teamId){
//        String teamStr = null;
//        JSONObject team = null;
//        try {
//            teamStr = JSONObject.toJSONString(teamDao.getTeamByTeamId(teamId));
//        }catch (Exception e){
//            System.out.println("diyibucuowu");
//        }
//        try {
//            team = JSONObject.parseObject(teamStr);
//        }catch (Exception e) {
//            System.out.println(teamStr);
//        }
        Team team = teamDao.getTeamByTeamId(teamId);
        if(team != null){
            JSONObject teamObject = JSONObject.parseObject(JSONObject.toJSONString(team));
            //String idList = JSON.toJSONString(teamDao.getUserIdByTeamId(teamId));

            String idList = StringUtils.join(teamDao.getUserIdByTeamId(teamId).toArray(),',');
            //JSONArray members = JSONArray.parseArray(JSON.toJSONString(teamDao.getUserIdByTeamId(teamId)));

            //向user-service发送请求，获取用户信息
            String userServiceUrl = "http://userservice";
            JSONObject response = restTemplate.getForObject(userServiceUrl+"/user/getusersbyids/?ids="+idList, JSONObject.class);
            JSONArray members = response.getJSONArray("data");
            JSONArray newMenbers = new JSONArray();
            for(int i = 0; i < members.size(); i++){
                JSONObject member = members.getJSONObject(i);
                member.remove("password");
                member.remove("baiduApi");
                newMenbers.add(member);
            }

            teamObject.put("members",newMenbers);
            return teamObject;
        }else {
            return null;
        }
    };

    public List<Team> getTeamByUserId(@Param("userId") Long userId){

        return teamDao.getTeamByUserId(userId);
    };
}
