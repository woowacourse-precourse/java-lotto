package lotto.domain.winning;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lotto.domain.ball.Ball;
import lotto.domain.ball.BallEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {
    
    WinningStatistic winningStatistic;
    
    @BeforeEach
    void setUp() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.NORMAL, 6)
        );
        
        Optional<WinningRank> winningRank = WinningRank.getRank(matchBalls);
        WinningDetail winningDetail = new WinningDetail(winningRank.get(), matchBalls);
        winningStatistic = new WinningStatistic(List.of(winningDetail));
    }
    
    @DisplayName("수익률의 3자리마다 콤마로 구분하고 퍼센트로 끝나는 문자열을 반환해야 한다.")
    @Test
    void getTextByRateOfReturn() {
        Integer purchaseAmount = 2000000;
        assertThat(winningStatistic.getTextByRateOfReturn(purchaseAmount)).isEqualTo("100,000.0%");
    }
    
    @DisplayName("수익률의 3자리마다 콤마로 구분하고 퍼센트로 끝나는 문자열을 반환해야 한다.")
    @Test
    void getTextByRateOfReturn2() {
        Integer purchaseAmount = 200000;
        assertThat(winningStatistic.getTextByRateOfReturn(purchaseAmount)).isEqualTo("1,000,000.0%");
    }
    
    @DisplayName("수익률의 3자리마다 콤마로 구분하고 퍼센트로 끝나는 문자열을 반환해야 한다.")
    @Test
    void getTextByRateOfReturn3() {
        Integer purchaseAmount = 2000000000;
        assertThat(winningStatistic.getTextByRateOfReturn(purchaseAmount)).isEqualTo("100.0%");
    }
}
