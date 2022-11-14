package lotto.domain.winning.statistic;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningRank;
import lotto.domain.winning.ball.Ball;
import lotto.domain.winning.ball.BallEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticViewTest {
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
        assertThat(WinningStatisticView.getTextByRateOfReturn(winningStatistic, purchaseAmount)).isEqualTo("100,000"
                + ".0%");
    }
    
    @DisplayName("수익률의 3자리마다 콤마로 구분하고 퍼센트로 끝나는 문자열을 반환해야 한다.")
    @Test
    void getTextByRateOfReturn2() {
        Integer purchaseAmount = 200000;
        assertThat(WinningStatisticView.getTextByRateOfReturn(winningStatistic, purchaseAmount)).isEqualTo("1,000,000"
                + ".0%");
    }
    
    @DisplayName("수익률의 3자리마다 콤마로 구분하고 퍼센트로 끝나는 문자열을 반환해야 한다.")
    @Test
    void getTextByRateOfReturn3() {
        Integer purchaseAmount = 2000000000;
        assertThat(WinningStatisticView.getTextByRateOfReturn(winningStatistic, purchaseAmount)).isEqualTo("100.0%");
    }
    
    @DisplayName("등수가 낮은 순으로 맞힌 개수를 포함한 내역 리스트를 반환한다.")
    @Test
    void getAllWinningTextList() {
        assertThat(WinningStatisticView.getWinningTextList(WinningRank.getSortedListByRankASC(),
                winningStatistic.getWinningCountByRank())).isEqualTo(List.of(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개"
        ));
    }
}
