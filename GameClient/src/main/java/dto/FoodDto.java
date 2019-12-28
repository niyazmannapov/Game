package dto;

import component.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FoodDto implements DTO {
    private double positionX;
    private double positionY;

    public static FoodDto from(Food food) {
        FoodDto foodDto = new FoodDto(food.getCenterX(), food.getCenterY());
        return foodDto;
    }
}
