package com.renchaigao.zujuba.mxtworldserver.service.impl;

import com.renchaigao.zujuba.domain.response.RespCode;
import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.PlayerInfo;
import com.renchaigao.zujuba.mongoDB.info.PlayersInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleDoingInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.World.MxtWorldGameDoingData;
import com.renchaigao.zujuba.mongoDB.info.team.TeamInfo;
import com.renchaigao.zujuba.mongoDB.info.team.teamGameInfo;
import com.renchaigao.zujuba.mxtworldserver.service.GameFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class GameFlowServiceImpl implements GameFlowService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MapServiceImpl mapServiceImpl;
    @Autowired
    RoleServiceImpl roleServiceImpl;

    @Override
    public ResponseEntity startNewGame(String teamInfoId, Integer mapSum) {
//        1、获取组队信息
        TeamInfo teamInfo = mongoTemplate.findById(teamInfoId, TeamInfo.class);
        PlayersInfo playersInfo = teamInfo.getTeamPlayerInfo();
//        1.5、获取游戏类型
        if (teamInfo.getTeamGameInfo().isSelect_MXTSJ()){
            MxtWorldGameDoingData mxtWorldGameDoingData = new MxtWorldGameDoingData();
//        2、修改玩家playerInfo的相关信息，已经进入游戏了。
//        3、初始化地图信息
            mxtWorldGameDoingData.setWorldMaps(mapServiceImpl.initNewMap(mapSum));
//        4、初始化role信息
            mxtWorldGameDoingData.setRoleInfoList(roleServiceImpl.initAllRoleInfo(teamInfo));
//        5、修改teamInfo信息，
            teamInfo.getTeamGameInfo().setState("INIT");//由WAIT 等待状态进入 初始完成状态INIT。
            return new ResponseEntity(RespCode.SUCCESS, mxtWorldGameDoingData);
        }else return null;
    }

    @Override
    public ResponseEntity getGameInfo(String teamInfoId, String userId) {
//        1、获取teamInfo信息
        TeamInfo teamInfo = mongoTemplate.findById(teamInfoId, TeamInfo.class);
//        2、获取GameInfo信息
        teamGameInfo teamGameInfo = teamInfo.getTeamGameInfo();
//        3、根据state分别给出不同的指引
        if (teamInfo.getTeamGameInfo().isSelect_MXTSJ()){
            switch (teamGameInfo.getState()){
                case "WAIT":
                    return new ResponseEntity(RespCode.GAMEWAIT, null);
                case "INIT":
                    MxtWorldGameDoingData mxtWorldGameDoingData = getMxtGameData(teamGameInfo.getGameDataId());
                    return new ResponseEntity(RespCode.GAMEINIT, mxtWorldGameDoingData);
                case "DOING":
                    return new ResponseEntity(RespCode.GAMEDOING, null);
            }
            return new ResponseEntity(RespCode.WARN, null);
        }else return null;
    }

    @Override
    public ResponseEntity updateGameInfo(RoleDoingInfo roleDoingInfo) {
        return null;
    }

    private MxtWorldGameDoingData getMxtGameData(String dataId){
        return mongoTemplate.findById(dataId,MxtWorldGameDoingData.class);
    }
}
