package component;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GameMap {
    private  ArrayList<GameCircle> gameCircleArrayList;
    private  ArrayList<Food> foodArrayList;
    private static GameMap instance;

    public  ArrayList<GameCircle> getGameCircleArrayList() {
        return gameCircleArrayList;
    }

    public  void setGameCircleArrayList(ArrayList<GameCircle> gameCircleArrayList) {
        this.gameCircleArrayList = gameCircleArrayList;
    }

    public  ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public void setFoodArrayList(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    private GameMap() {
        gameCircleArrayList = new ArrayList<>();
        foodArrayList = new ArrayList<>();
        instance = this;
    }

    public static GameMap getInstance() {
        if (instance == null) {
            return new GameMap();
        } else return instance;
    }

    public void addGameCircle(GameCircle gc) {
        this.gameCircleArrayList.add(gc);
    }

    public  void addFood(Food food) {
        this.foodArrayList.add(food);
    }
}
