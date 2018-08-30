package com.renchaigao.zujuba.mxtworldserver.controller;

import com.renchaigao.zujuba.domain.response.ResponseEntity;
import com.renchaigao.zujuba.mxtworldserver.service.impl.GameFlowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/world")
public class GameFlowController {

    @Autowired
    GameFlowServiceImpl gameFlowServiceImpl;

    @PostMapping(value = "/start/{mapsum}",consumes = "application/json")
    @ResponseBody
    public ResponseEntity startNewGame(@PathVariable("mapsum") Integer mapSum,String teamInfoId){
        return gameFlowServiceImpl.startNewGame(teamInfoId,mapSum);
    }

}
