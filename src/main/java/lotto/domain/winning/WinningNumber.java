package lotto.domain.winning;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.winning.ball.Ball;
import lotto.domain.winning.ball.BallEnum;

public class WinningNumber {
    
    private final List<Ball> balls = new ArrayList<>();
    
    public WinningNumber(List<Integer> normalNumbers, List<Integer> bonusNumbers) {
        normalNumbers.forEach((normalNumber) -> balls.add(new Ball(BallEnum.NORMAL, normalNumber)));
        bonusNumbers.forEach((bonusNumber) -> balls.add(new Ball(BallEnum.BONUS, bonusNumber)));
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
