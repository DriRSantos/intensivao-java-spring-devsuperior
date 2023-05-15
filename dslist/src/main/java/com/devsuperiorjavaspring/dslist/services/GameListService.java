package com.devsuperiorjavaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiorjavaspring.dslist.dto.GameListDTO;
import com.devsuperiorjavaspring.dslist.entities.GameList;
import com.devsuperiorjavaspring.dslist.projections.GameMinProjection;
import com.devsuperiorjavaspring.dslist.repositories.GameListRepository;
import com.devsuperiorjavaspring.dslist.repositories.GameRepository;

@Service
//@Component
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
//		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
//		return dto;
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}	
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {

		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
