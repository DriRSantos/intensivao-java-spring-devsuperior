package com.devsuperiorjavaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiorjavaspring.dslist.dto.GameListDTO;
import com.devsuperiorjavaspring.dslist.entities.GameList;
import com.devsuperiorjavaspring.dslist.repositories.GameListRepository;

@Service
//@Component
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
//		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
//		return dto;
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}	
}
