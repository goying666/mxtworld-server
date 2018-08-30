package com.renchaigao.zujuba.mxtworldserver.service.impl;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Task.TaskBasic;
import com.renchaigao.zujuba.mxtworldserver.service.EquipmentService;
import com.renchaigao.zujuba.mxtworldserver.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {


    @Override
    public ResponseEntity addNewTaskBasic(TaskBasic taskBasic) {
        return null;
    }

    @Override
    public ResponseEntity updateTaskBasic(TaskBasic taskBasic) {
        return null;
    }

    @Override
    public ResponseEntity deleteTaskBasic(TaskBasic taskBasic) {
        return null;
    }

    @Override
    public ResponseEntity initRoleTaskBasicInfo(RoleInfo roleInfo) {
        return null;
    }
}
