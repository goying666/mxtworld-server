package com.renchaigao.zujuba.mxtworldserver.service;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;

public interface RoleService {
    ResponseEntity addNewRoleBasic(RoleBasic roleBasic);
    ResponseEntity updateRoleBasic(RoleBasic roleBasic);
    ResponseEntity deleteRoleBasic(RoleBasic roleBasic);
    ResponseEntity initRoleInfo(RoleInfo roleInfo);
}
