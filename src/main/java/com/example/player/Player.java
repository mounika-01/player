package com.example.player;

public class Player{
    private int playerId;
    private String playerName;
    private int jerseyNumber;
    private String role;

    public Player(int playerId,String playerName, int jerseyNumber,String role){

        this.playerId=playerId;
        this.playerName=playerName;
        this.jerseyNumber=jerseyNumber;
        this.role=role;

    }

    public void setId(int playerId){
        this.playerId=playerId;
    }

    public int getId(){
        return playerId;
    }

    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setjerseyNumber(int jerseyNumber){
        this.jerseyNumber=jerseyNumber;
    }
    public int getjerseyNumber(){
        return jerseyNumber;
    }

    public void setrole(String role){
        this.role=role;
    }

    public String getrole(){
        return role;
    }
}
