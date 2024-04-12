package com.example.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();
    private int uniqueId = 12; // Starting ID for new players

    public PlayerService() {
        // Initialize some players for demonstration
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> playerCollection = team.values();
        return new ArrayList<>(playerCollection);
    }

    @Override
    public Player getPlayerById(int playerId) {
        Player player = team.get(playerId);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }
        return player;
    }

    @Override
    public Player addPlayer(Player player) {
        player.setPlayerId(uniqueId++);
        team.put(player.getPlayerId(), player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerId, Player updatedPlayer) {
        Player existingPlayer = team.get(playerId);
        if (existingPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }
        // Update player information
        if (updatedPlayer.getPlayerName() != null) {
            existingPlayer.setPlayerName(updatedPlayer.getPlayerName());
        }
        if (updatedPlayer.getJerseyNumber() != 0) {
            existingPlayer.setJerseyNumber(updatedPlayer.getJerseyNumber());
        }
        if (updatedPlayer.getRole() != null) {
            existingPlayer.setRole(updatedPlayer.getRole());
        }
        return existingPlayer;
    }

@Override
    public void deletePlayer(int playerId) {


        Player player = team.get(playerId);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
