package lotto.domain.winning;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.ball.Ball;
import lotto.domain.ball.BallEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    
    WinningNumber winningNumber;
    
    @BeforeEach
    void setUp() {
        List<Ball> balls = List.of(new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.BONUS, 6)
        );
        
        winningNumber = new WinningNumber(balls);
    }
    
    @DisplayName("일반 타입의 추첨 볼을 모두 반환해야 한다.")
    @Test
    void getNormalNumbers() {
        List<Ball> normalNumbers = winningNumber.getNormalNumbers();
        assertThat(normalNumbers.size()).isEqualTo(5);
        normalNumbers.forEach((ball) -> assertThat(ball.getType()).isEqualTo(BallEnum.NORMAL));
    }
    
    @DisplayName("보너스 타입의 추첨 볼을 모두 반환해야 한다.")
    @Test
    void getBonusNumbers() {
        List<Ball> bonusNumbers = winningNumber.getBonusNumbers();
        assertThat(bonusNumbers.size()).isEqualTo(1);
        bonusNumbers.forEach((ball) -> assertThat(ball.getType()).isEqualTo(BallEnum.BONUS));
    }
}
