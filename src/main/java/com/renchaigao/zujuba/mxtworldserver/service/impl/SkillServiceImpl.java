package com.renchaigao.zujuba.mxtworldserver.service.impl;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Skill.SkillBasic;
import com.renchaigao.zujuba.mxtworldserver.service.EquipmentService;
import com.renchaigao.zujuba.mxtworldserver.service.SkillService;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    @Override
    public ResponseEntity addNewSkillBasic(SkillBasic skillBasic) {
        return null;
    }

    @Override
    public ResponseEntity updateSkillBasic(SkillBasic skillBasic) {
        return null;
    }

    @Override
    public ResponseEntity deleteSkillBasic(SkillBasic skillBasic) {
        return null;
    }

    @Override
    public ResponseEntity initRoleSkillInfo(RoleInfo roleInfo) {
        return null;
    }
}
