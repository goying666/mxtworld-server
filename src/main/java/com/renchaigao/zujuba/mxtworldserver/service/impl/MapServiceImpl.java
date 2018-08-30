package com.renchaigao.zujuba.mxtworldserver.service.impl;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Equip.EquipmentBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Map.GameOneMapInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Map.MapBasic;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.Role.RoleInfo;
import com.renchaigao.zujuba.mongoDB.info.game.MXTWorld.World.GameMapsInfo;
import com.renchaigao.zujuba.mxtworldserver.service.EquipmentService;
import com.renchaigao.zujuba.mxtworldserver.service.MapService;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Log4j
@Service
public class MapServiceImpl implements MapService {

//    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity addNewMapBasic(MapBasic mapBasic) {
        return null;
    }

    @Override
    public ResponseEntity updateMapBasic(MapBasic mapBasic) {
        return null;
    }

    @Override
    public ResponseEntity deleteMapBasic(MapBasic mapBasic) {
        return null;
    }

    @Override
    public ResponseEntity initRoleMapInfo(RoleInfo roleInfo) {
        return null;
    }

    public GameMapsInfo initNewMap(Integer mapSum) {
        long startTime = System.currentTimeMillis();    //开始时间
//        1、不同类型地图数量确定，随机从库中取出固定数量的地图；
        Integer cityMap = (int) Math.ceil(mapSum * 0.25);
        Integer fieldMap = mapSum - cityMap;
        Random random = new Random();
        List<MapBasic> allCityMapList = mongoTemplate.find(Query.query(Criteria.where("form").is("CITY")), MapBasic.class);
        ArrayList<MapBasic> selectAllMaps = new ArrayList<MapBasic>() {
            {
                for (int i = 0; i < cityMap; i++) {
                    int j = random.nextInt(allCityMapList.size() - 1);
                    add(allCityMapList.get(j));
                    allCityMapList.remove(j);
                }
            }
        };
        List<MapBasic> allFieldMapList = mongoTemplate.find(Query.query(Criteria.where("form").is("FIELD")), MapBasic.class);
        for (int i = 0; i < fieldMap; i++) {
            int j = random.nextInt(allFieldMapList.size() - 1);
            selectAllMaps.add(allFieldMapList.get(j));
            allFieldMapList.remove(j);
        }
//        2、为不同地图匹配地图号（连续从0~mapSum）；
        ArrayList<GameOneMapInfo> allGameMapInfo = new ArrayList<>();
        for (int i = 0;i<selectAllMaps.size();i++){
            int j = random.nextInt(selectAllMaps.size() - 1);
            GameOneMapInfo gameOneMapInfo = (GameOneMapInfo) selectAllMaps.get(j);
            gameOneMapInfo.setNumber(i);
            allGameMapInfo.add(gameOneMapInfo);
            selectAllMaps.remove(j);
            if (gameOneMapInfo.getForm().equals("CITY")){
//        4、初始化 城镇地图的 交易信息 和 技能信息 和 其他信息；

            }else if(gameOneMapInfo.getForm().equals("FIELD")){
//        3、初始化 野外地图的 狩猎信息 和 副本信息；

            }
        }
        GameMapsInfo gameMapsInfo = new GameMapsInfo();
        gameMapsInfo.setGameAllMapsList(allGameMapInfo);
        gameMapsInfo.setMapNum(mapSum);
        long endTime = System.currentTimeMillis();    //结束时间
        log.debug("initNewMap has spend time is : " + (endTime - startTime));
        return gameMapsInfo;
    }
}
