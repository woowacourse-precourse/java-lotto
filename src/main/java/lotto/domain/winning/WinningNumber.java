package lotto.domain.winning;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.ball.Ball;
import lotto.domain.ball.BallEnum;

public class WinningNumber {
    
    private final List<Ball> balls;
    
    public WinningNumber(List<Ball> balls) {
        this.balls = balls;
    }
    
    public List<Ball> getNormalNumbers() {
        return filterByBallType(BallEnum.NORMAL).collect(Collectors.toList());
    }
    
    public List<Ball> getBonusNumbers() {
        return filterByBallType(BallEnum.BONUS).collect(Collectors.toList());
    }
    
    private Stream<Ball> filterByBallType(BallEnum type) {
        return balls.stream().filter((ball) -> ball.getType().equals(type));
    }
}
