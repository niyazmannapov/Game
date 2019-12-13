package dto;

import component.GameCircle;
import javafx.scene.shape.Circle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CircleDto implements DTO {
    private double radius;
    private double positionX;
    private double positionY;

    public static CircleDto from(GameCircle circle) {
        CircleDto circleDto = new CircleDto(circle.getRadius(), circle.getCenterX(), circle.getCenterY());
        return circleDto;
    }
}
