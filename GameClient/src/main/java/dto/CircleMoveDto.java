package dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CircleMoveDto implements DTO {
    public CircleMoveDto() {
        velocityX = 0;
        velocityY = 0;
        elapsedTime = 0;
    }

    private double velocityX;
    private double velocityY;
    private double elapsedTime;
}
