package com.renchaigao.zujuba.mxtworldserver.service;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.PlayerInfo;
import com.renchaigao.zujuba.mongoDB.info.PlayersInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleDoingInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.World.MxtWorldGameDoingData;

import javax.management.relation.RoleInfo;

public interface GameFlowService {
    ResponseEntity startNewGame(String teamInfoId,Integer mapSum);
    ResponseEntity getGameInfo(String teamInfoId,String userId);
    ResponseEntity updateGameInfo(RoleDoingInfo roleDoingInfo);

}
