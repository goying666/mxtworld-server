package com.renchaigao.zujuba.mxtworldserver.service;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Task.TaskBasic;

public interface TaskService {
    ResponseEntity addNewTaskBasic(TaskBasic taskBasic);
    ResponseEntity updateTaskBasic(TaskBasic taskBasic);
    ResponseEntity deleteTaskBasic(TaskBasic taskBasic);

    ResponseEntity initRoleTaskBasicInfo(RoleInfo roleInfo);
}
