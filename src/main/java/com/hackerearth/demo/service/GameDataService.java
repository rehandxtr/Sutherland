package com.hackerearth.demo.service;

import com.hackerearth.demo.dao.GameData;
import com.hackerearth.demo.repository.GameDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameDataService {
    @Autowired
    GameDataRepository gameDataRepository;
    public void save(GameData gameData) {
        gameDataRepository.save(gameData);
    }

    public List<GameData> listAll() {
        return gameDataRepository.findAll();
    }

    public List<GameData> searchData(String keyword) {
        List<GameData> gameData= gameDataRepository.findAllByTitleOrGenreOrPlatformIsContaining(keyword,keyword,keyword);
        return gameData;
    }

    public void delete(Long id) {
        gameDataRepository.deleteById(id);
    }
    public GameData get(Long id) {
        return gameDataRepository.findById(id).get();
    }
}
