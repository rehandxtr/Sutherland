package com.hackerearth.demo.controller;

import com.hackerearth.demo.dao.GameData;
import com.hackerearth.demo.service.GameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class CRUDController {
    @Autowired
    private GameDataService gameDataService;

    @DeleteMapping("/data/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        try {
            gameDataService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception in deleting the post", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(headers = "Accept=application/JSON",value = "/data")
    @ResponseBody
    public ResponseEntity<String>  savePost(@RequestBody GameData gameData) {
        try {
            gameDataService.save(gameData);
        } catch (Exception e) {
            return new ResponseEntity<>("Post creation failed", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("saved",HttpStatus.OK);
    }

    @PutMapping(headers = "Accept=application/JSON",value = "/data/{id}")
    @ResponseBody
    public ResponseEntity<String> editPost(@PathVariable("id") long id,@RequestBody GameData gameData) {
        GameData gameData1=gameDataService.get(id);
       gameData1.setTitle(gameData.getTitle());
       gameData1.setScore(gameData.getScore());
       gameData1.setEditors_choice(gameData.getEditors_choice());
       gameData1.setGenre(gameData.getGenre());
       gameData1.setPlatform(gameData.getPlatform());
        try {
            gameDataService.save(gameData1);
        } catch (Exception e) {
            return new ResponseEntity<>("Post updated failed", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("updated",HttpStatus.OK);
    }

    @GetMapping("/data/{id}")
    @ResponseBody
    public ResponseEntity<?> viewPost(@PathVariable long id) {
        GameData gameData;
        try {
            gameData = gameDataService.get(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Post not Present", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(gameData, HttpStatus.OK);
    }
}