package com.renchaigao.zujuba.mxtworldserver.service.impl;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mongoDB.info.team.TeamInfo;
import com.renchaigao.zujuba.mxtworldserver.service.EquipmentService;
import com.renchaigao.zujuba.mxtworldserver.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public ResponseEntity addNewRoleBasic(RoleBasic roleBasic) {
        return null;
    }

    @Override
    public ResponseEntity updateRoleBasic(RoleBasic roleBasic) {
        return null;
    }

    @Override
    public ResponseEntity deleteRoleBasic(RoleBasic roleBasic) {
        return null;
    }

    @Override
    public ResponseEntity initRoleInfo(RoleInfo roleInfo) {
        return null;
    }

    public ArrayList<RoleInfo> initAllRoleInfo(TeamInfo teamInfo){
        return null;
    }
}
