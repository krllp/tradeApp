package com.tradeapp.storage;

import com.tradeapp.entities.ManagerEntity;
import com.tradeapp.entities.PlayerEntity;
import com.tradeapp.entities.TeamEntity;

import java.util.List;

public class Storage {

    public static final Storage INSTANCE = new Storage();

    private Storage() {
    }

    private List<TeamEntity> teams;
    private List<ManagerEntity> managers;
    private List<PlayerEntity> players;

    public List<TeamEntity> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamEntity> teams) {
        this.teams = teams;
    }

    public List<ManagerEntity> getManagers() {
        return managers;
    }

    public void setManagers(List<ManagerEntity> managers) {
        this.managers = managers;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }
}
