package lotto.domain.winning;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lotto.domain.ball.Ball;
import lotto.domain.ball.BallEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningDetailTest {

    @DisplayName("WinningRank를 인수로 생성된 인스턴스의 getRank 메소드는 Empty를 반환하지 않는다.")
    @Test
    void getRankWithWinningRank() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.NORMAL, 6)
        );
        Optional<WinningRank> winningRank = WinningRank.getRank(matchBalls);
        
        assertThat(winningRank).isNotEmpty();
    
        winningRank.ifPresent((rank) -> {
            WinningDetail winningDetail = new WinningDetail(rank, matchBalls);
            assertThat(winningDetail.getRank()).isNotEmpty();
        });
    }
    
    @DisplayName("WinningRank가 없이 생성된 인스턴스의 getRank 메소드는 Empty를 반환한다.")
    @Test
    void getRankWithoutWinningRank() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2)
        );
        
        WinningDetail winningDetail = new WinningDetail(matchBalls);
        assertThat(winningDetail.getRank()).isEmpty();
    }
}
