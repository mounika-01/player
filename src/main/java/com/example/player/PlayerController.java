package com.example.player;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import com.example.player.PlayerService;

@RestController
public class PlayerController {

    PlayerService playerservice = new PlayerService();

    @GetMapping("/players")

    public ArrayList<Player> getPlayersList() {
        return playerservice.getPlayers();

    }

    @GetMapping("/players/{playerId}")
    public Player getPlayer(@PathVariable("playerId") int playerId) {
        return playerservice.getPlayerById(playerId); // Update method call here
    }

    @PostMapping("/players")

    public Player addPlayer(@RequestBody Player player) {
        return playerservice.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")

    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {

        return playerservice.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")

    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerservice.deletePlayer(playerId);
    }

}
