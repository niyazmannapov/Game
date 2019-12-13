package dto;

import component.Food;
import component.GameCircle;
import component.GameMap;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class MapInfoDto implements DTO {
    private ArrayList<CircleDto> circleDtoArrayList;
    private ArrayList<FoodDto> foodArrayList;

    public static MapInfoDto from(GameMap gameMap) {
        ArrayList<CircleDto> circleDtos = new ArrayList<>();
        ArrayList<FoodDto> foodDtos = new ArrayList<>();


        for (GameCircle gc : gameMap.getGameCircleArrayList()) {
            circleDtos.add(new CircleDto(gc.getRadius(), gc.getCenterX(), gc.getCenterY()));
        }

        for (Food food : gameMap.getFoodArrayList()) {
            foodDtos.add(new FoodDto(food.getCenterX(), food.getCenterY()));
        }
        return MapInfoDto.builder().foodArrayList(foodDtos).circleDtoArrayList(circleDtos).build();
    }
}
