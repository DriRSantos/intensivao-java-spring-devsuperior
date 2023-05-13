package com.devsuperiorjavaspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorjavaspring.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
