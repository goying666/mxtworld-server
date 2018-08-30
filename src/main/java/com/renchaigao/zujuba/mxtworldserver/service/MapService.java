package com.renchaigao.zujuba.mxtworldserver.service;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Map.MapBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;

public interface MapService {
    ResponseEntity addNewMapBasic(MapBasic mapBasic);
    ResponseEntity updateMapBasic(MapBasic mapBasic);
    ResponseEntity deleteMapBasic(MapBasic mapBasic);

    ResponseEntity initRoleMapInfo(RoleInfo roleInfo);

//    ResponseEntity initNewMap(Integer mapSum);
}
