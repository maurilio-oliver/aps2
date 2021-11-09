package model;

public class UserModel {
    private String points;

    private String name;

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserModel [name=" + name + ", points=" + points + "]".replace("=", "=>");
    }

    
}
