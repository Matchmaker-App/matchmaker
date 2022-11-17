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

    public void addGame(GameModel gameModel){
        gameRepository.save(gameModel);
        log.info("Dodano grę: " + gameModel.getId());
    }

    public void editGame(GameModel gameModel){
        gameRepository.save(gameModel);
    }

    public void deleteGameById(Long id){
        gameRepository.deleteById(id);
        log.info("Usunięto grę o id" + id);
    }

    public GameModel getGameById(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public List<GameModel> getGame(){
        return gameRepository.findAll();
    }
}
