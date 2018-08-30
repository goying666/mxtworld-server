package com.renchaigao.zujuba.mxtworldserver.controller;

import com.alibaba.fastjson.JSONObject;
import com.renchaigao.zujuba.dao.User;
import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mxtworldserver.service.impl.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/equip")
public class EquipmentController {

    @Autowired
    EquipmentServiceImpl equipmentServiceImpl;

    @PostMapping(value = "/add",consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity addNewEquipment(@RequestParam("json") String equipmentBasicString,
                                          @RequestParam("image") MultipartFile image){
//        EquipmentBasic equipmentBasicUse = new EquipmentBasic();
//        equipmentBasicUse.setName("小刀");
//        equipmentBasicUse.setEffect("1");
//        equipmentBasicUse.setForm("Z-GJ");
//        equipmentBasicUse.setGrade("新手");
//        equipmentBasicUse.setIntroduce("\"平平无奇却必不可少的求生道具\"");
//        equipmentBasicUse.setPrice(1);
//        String str = JSONObject.toJSONString(equipmentBasicUse);

        return equipmentServiceImpl.addNewEquipmentBasic(
                JSONObject.parseObject(equipmentBasicString,EquipmentBasic.class),image);
    }

}
