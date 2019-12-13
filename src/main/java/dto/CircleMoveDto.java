package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CircleMoveDto implements DTO {
    private double velocityX;
    private double velocityY;
    private double elapsedTime;
}
