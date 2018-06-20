package com.tradeapp.entities;

public class PlayerEntity {

    private Long ID;
    private String name;
    private int salary;
    private Long teamID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerEntity that = (PlayerEntity) o;

        if (salary != that.salary) return false;
        if (ID != null ? !ID.equals(that.ID) : that.ID != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return teamID != null ? teamID.equals(that.teamID) : that.teamID == null;
    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (teamID != null ? teamID.hashCode() : 0);
        return result;
    }
}
