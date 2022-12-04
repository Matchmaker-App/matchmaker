package com.matchmaker.matchmaker.game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;

    protected GameController (GameService gameService) {
        this.gameService = gameService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/games")
    public @ResponseBody
    ResponseEntity<List<Game>> getGame(@PathVariable(required = false, name="gameId") Long id,
                                       @PathVariable(required = false, name="name") String name,
                                       @PathVariable(required = false, name="rating") Double rating,
                                       @PathVariable(required = false, name="description") String description,
                                       @PathVariable(required = false, name="platform") String platform) {
        if(id == null && name == null && rating == null && description == null && platform == null){
            return new ResponseEntity<>(gameService.getGame(), HttpStatus.OK);
        }
        Game game = gameService.getGameById(id);
        return new ResponseEntity(game, HttpStatus.OK);
    }

    @PostMapping("/games/addGame")
    public ResponseEntity addGame(@RequestBody Game game){
        gameService.addGame(game);
        return ResponseEntity.ok(game);
    }


    @PutMapping("/games/editGame")
    public ResponseEntity editGame(@RequestBody Game game){
        gameService.editGame(game);
        return ResponseEntity.ok(game);
    }

    @DeleteMapping("/games/deleteGame")
    public ResponseEntity deleteGame(@RequestParam("id") Long id){
        gameService.deleteGameById(id);
        return ResponseEntity.ok(null);
    }

}
