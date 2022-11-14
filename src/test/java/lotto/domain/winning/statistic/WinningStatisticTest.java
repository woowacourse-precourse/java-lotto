package lotto.domain.winning.statistic;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.ball.Ball;
import lotto.domain.winning.ball.BallEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {
    
    @DisplayName("당첨 등수를 Key로 당첨 된 개수를 Value로 갖는 Counter 맵을 반환한다.")
    @Test
    void getWinningCountByRank() {
        List<Ball> matchBalls1 = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.NORMAL, 6)
        );
        
        List<Ball> matchBalls2 = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.BONUS, 6)
        );
        
        WinningDetail winningDetail1 = new WinningDetail(WinningRank.getRank(matchBalls1).get(), matchBalls1);
        WinningDetail winningDetail2 = new WinningDetail(WinningRank.getRank(matchBalls2).get(), matchBalls2);
        
        WinningStatistic winningStatistic = new WinningStatistic(
                List.of(winningDetail1, winningDetail2, winningDetail2));
        
        Map<Integer, Integer> winningCountByRank = winningStatistic.getWinningCountByRank();
        
        assertThat(winningCountByRank.get(winningDetail1.getRank().getRank())).isEqualTo(1);
        assertThat(winningCountByRank.get(winningDetail2.getRank().getRank())).isEqualTo(2);
    }
    
    @DisplayName("당첨된 등수의 모든 Reward를 합한 값을 반환한다.")
    @Test
    void getTotalReward() {
        List<Ball> matchBalls1 = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.NORMAL, 6)
        );
        
        List<Ball> matchBalls2 = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4)
                );
        
        WinningDetail winningDetail1 = new WinningDetail(WinningRank.getRank(matchBalls1).get(), matchBalls1);
        WinningDetail winningDetail2 = new WinningDetail(WinningRank.getRank(matchBalls2).get(), matchBalls2);
        
        WinningStatistic winningStatistic = new WinningStatistic(
                List.of(winningDetail1, winningDetail2));
        
        assertThat(winningStatistic.getTotalReward()).isEqualTo(
                winningDetail1.getRank().getReward() + winningDetail2.getRank().getReward());
    }
}
