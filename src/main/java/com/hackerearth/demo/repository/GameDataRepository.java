package com.hackerearth.demo.repository;

import com.hackerearth.demo.dao.GameData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDataRepository extends JpaRepository<GameData, Long> {
    List<GameData> findAllByTitleOrGenreOrPlatformIsContaining(String keyword,String keyword1,String keyword2);
}
