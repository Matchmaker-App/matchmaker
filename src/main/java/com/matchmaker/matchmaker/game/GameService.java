package com.matchmaker.matchmaker.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GameService {

    private GameRepository gameRepository;
    protected GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void addGame(Game game){
        gameRepository.save(game);
        log.info("The game have been added: " + game.getId());
    }

    public void editGame(Game game){
        gameRepository.save(game);
    }

    public void deleteGameById(Long id){
        gameRepository.deleteById(id);
        log.info("The game with id: " + id + " have been added.");
    }

    public Game getGameById(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public List<Game> getGame(){
        return gameRepository.findAll();
    }
}
