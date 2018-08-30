package com.renchaigao.zujuba.mxtworldserver.service;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Skill.SkillBasic;

public interface SkillService {
    ResponseEntity addNewSkillBasic(SkillBasic skillBasic);
    ResponseEntity updateSkillBasic(SkillBasic skillBasic);
    ResponseEntity deleteSkillBasic(SkillBasic skillBasic);

    ResponseEntity initRoleSkillInfo(RoleInfo roleInfo);
}
