package com.renchaigao.zujuba.mxtworldserver.service;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import org.springframework.web.multipart.MultipartFile;

public interface EquipmentService {
    ResponseEntity addNewEquipmentBasic(EquipmentBasic equipmentBasic , MultipartFile image);
    ResponseEntity updateEquipmentBasic(EquipmentBasic equipmentBasic);
    ResponseEntity deleteEquipmentBasic(EquipmentBasic equipmentBasic);


    ResponseEntity initRoleEquipmentInfo(RoleInfo roleInfo);
}
