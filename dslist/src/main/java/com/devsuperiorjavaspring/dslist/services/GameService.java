package com.devsuperiorjavaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiorjavaspring.dslist.dto.GameDTO;
import com.devsuperiorjavaspring.dslist.dto.GameMinDTO;
import com.devsuperiorjavaspring.dslist.entities.Game;
import com.devsuperiorjavaspring.dslist.repositories.GameRepository;

@Service
//@Component
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
//		GameDTO dto = new GameDTO(result);
//		return dto;				
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
//		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
//		return dto;
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}	
}
