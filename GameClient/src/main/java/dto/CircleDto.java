package dto;

import component.GameCircle;
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
    private long gameId;

    public static CircleDto from(GameCircle circle) {
        CircleDto circleDto = new CircleDto(circle.getRadius(), circle.getCenterX(), circle.getCenterY(), circle.getGameId());
        return circleDto;
    }
}
