package lotto.domain.winning.statistic;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.ball.Ball;
import lotto.domain.winning.ball.BallEnum;
import org.junit.jupiter.api.BeforeEach;

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
    
}
