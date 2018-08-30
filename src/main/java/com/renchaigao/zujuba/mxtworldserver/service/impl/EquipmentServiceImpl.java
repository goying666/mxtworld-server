package com.renchaigao.zujuba.mxtworldserver.service.impl;

import com.renchaigao.zujuba.domain.response.RespCode;
import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mxtworldserver.service.EquipmentService;
import normal.UUIDUtil;
import normal.dateUse;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    MongoTemplate mongoTemplate;

    /**********************************************
     * 功能：生成系统下 各装备对应的/ZJB/game/mxtWorld/equipment/pic/目录
     * 入参：装备id  equipId
     **********************************************/
    private String creatFilePathOnservice(String equipId, String part) {
        String path = "/ZJB/game/mxtWorld/" + part + "/pic/" + equipId;
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
        return path + "/";
    }

    @Override
    public ResponseEntity addNewEquipmentBasic(EquipmentBasic equipmentBasic, MultipartFile image) {
//        查重
        List<EquipmentBasic> equipmentBasicList = mongoTemplate.find(
                Query.query(Criteria.where("equipmentBasic.name").is(equipmentBasic.getName())), EquipmentBasic.class);
        if (equipmentBasicList.size() == 0) {
//        补全信息
            equipmentBasic.setId(UUIDUtil.getUUID());
            equipmentBasic.setUpTime(dateUse.GetStringDateNow());
            equipmentBasic.setDeleteStyle(false);
            equipmentBasic.setIsUse(false);
            String imagePath = creatFilePathOnservice(equipmentBasic.getId(), "equip") + image.getOriginalFilename();
            // 转存文件
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(imagePath)));
                out.write(image.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                return new ResponseEntity(RespCode.WARN, e.getMessage());
            } catch (IOException eIO) {
                return new ResponseEntity(RespCode.WARN, eIO.getMessage());
            }
            equipmentBasic.setImagePath(imagePath);
//        填入数据库
            mongoTemplate.save(equipmentBasic);
            return new ResponseEntity(RespCode.SUCCESS, equipmentBasic);
        } else {
            return new ResponseEntity(RespCode.EQUIPMENTBASICEXIST, equipmentBasic);
        }
    }

    @Override
    public ResponseEntity updateEquipmentBasic(EquipmentBasic equipmentBasic) {
        return null;
    }

    @Override
    public ResponseEntity deleteEquipmentBasic(EquipmentBasic equipmentBasic) {
        return null;
    }

    @Override
    public ResponseEntity initRoleEquipmentInfo(RoleInfo roleInfo) {
        return null;
    }
}
