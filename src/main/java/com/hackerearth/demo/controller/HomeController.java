package com.hackerearth.demo.controller;

import com.hackerearth.demo.dao.GameData;
import com.hackerearth.demo.service.GameDataService;
import com.hackerearth.demo.service.MyUserDetailsService;
import com.hackerearth.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class HomeController {
    @Autowired
    private GameDataService gameDataService;

    @GetMapping({"/"})
    public @ResponseBody
    ResponseEntity<List<GameData>> firstPage(@RequestParam(required = false) String keyword) {
        List<GameData> gameDataList;
        if (keyword == null) {
            gameDataList = gameDataService.listAll();
        } else {
            gameDataList = gameDataService.searchData(keyword);
        }
        return new ResponseEntity<>(gameDataList, HttpStatus.OK);
    }
}