package lotto.domain.winning;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import lotto.domain.winning.ball.Ball;
import lotto.domain.winning.ball.BallEnum;
import org.junit.jupiter.api.Test;

public class WinningRankTest {
    
    
    @Test
    void getRank_메소드는_6개의_일반_매치볼을_입력받으면_1등_랭크를_반환해야_한다() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.NORMAL, 6)
        );
        
        WinningRank expected = new WinningRank(1, 2000000000, 6, 0);
        Optional<WinningRank> result = WinningRank.getRank(matchBalls);
        assertThat(result).isNotEmpty();
        
        result.ifPresent((rank) -> {
            assertThat(rank.getRank()).isEqualTo(expected.getRank());
            assertThat(rank.getCountNormalMatch()).isEqualTo(expected.getCountNormalMatch());
            assertThat(rank.getCountBonusMatch()).isEqualTo(expected.getCountBonusMatch());
            assertThat(rank.getReward()).isEqualTo(expected.getReward());
        });
    }
    
    @Test
    void getRank_메소드는_5개의_일반_매치볼과_1개의_보너스_매치볼을_입력받으면_2등_랭크를_반환해야_한다() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5),
                new Ball(BallEnum.BONUS, 6)
        );
        
        WinningRank expected = new WinningRank(2, 30000000, 5, 1);
        Optional<WinningRank> result = WinningRank.getRank(matchBalls);
        assertThat(result).isNotEmpty();
        
        result.ifPresent((rank) -> {
            assertThat(rank.getRank()).isEqualTo(expected.getRank());
            assertThat(rank.getCountNormalMatch()).isEqualTo(expected.getCountNormalMatch());
            assertThat(rank.getCountBonusMatch()).isEqualTo(expected.getCountBonusMatch());
            assertThat(rank.getReward()).isEqualTo(expected.getReward());
        });
    }
    
    @Test
    void getRank_메소드는_5개의_일반_매치볼을_입력받으면_3등_랭크를_반환해야_한다() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4),
                new Ball(BallEnum.NORMAL, 5)
        );
        
        WinningRank expected = new WinningRank(3, 1500000, 5, 0);
        Optional<WinningRank> result = WinningRank.getRank(matchBalls);
        assertThat(result).isNotEmpty();
        
        result.ifPresent((rank) -> {
            assertThat(rank.getRank()).isEqualTo(expected.getRank());
            assertThat(rank.getCountNormalMatch()).isEqualTo(expected.getCountNormalMatch());
            assertThat(rank.getCountBonusMatch()).isEqualTo(expected.getCountBonusMatch());
            assertThat(rank.getReward()).isEqualTo(expected.getReward());
        });
    }
    
    @Test
    void getRank_메소드는_4개의_일반_매치볼을_입력받으면_4등_랭크를_반환해야_한다() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3),
                new Ball(BallEnum.NORMAL, 4)
        );
        
        WinningRank expected = new WinningRank(4, 50000, 4, 0);
        Optional<WinningRank> result = WinningRank.getRank(matchBalls);
        assertThat(result).isNotEmpty();
        
        result.ifPresent((rank) -> {
            assertThat(rank.getRank()).isEqualTo(expected.getRank());
            assertThat(rank.getCountNormalMatch()).isEqualTo(expected.getCountNormalMatch());
            assertThat(rank.getCountBonusMatch()).isEqualTo(expected.getCountBonusMatch());
            assertThat(rank.getReward()).isEqualTo(expected.getReward());
        });
    }
    
    @Test
    void getRank_메소드는_3개의_일반_매치볼을_입력받으면_5등_랭크를_반환해야_한다() {
        List<Ball> matchBalls = List.of(
                new Ball(BallEnum.NORMAL, 1),
                new Ball(BallEnum.NORMAL, 2),
                new Ball(BallEnum.NORMAL, 3)
        );
        
        WinningRank expected = new WinningRank(5, 5000, 3, 0);
        Optional<WinningRank> result = WinningRank.getRank(matchBalls);
        assertThat(result).isNotEmpty();
        
        result.ifPresent((rank) -> {
            assertThat(rank.getRank()).isEqualTo(expected.getRank());
            assertThat(rank.getCountNormalMatch()).isEqualTo(expected.getCountNormalMatch());
            assertThat(rank.getCountBonusMatch()).isEqualTo(expected.getCountBonusMatch());
            assertThat(rank.getReward()).isEqualTo(expected.getReward());
        });
    }
    
    @Test
    void getSortedListByRankASC_메소드는_순위로_정렬된_리스트를_반환한다() {
        List<WinningRank> sortedListByRankASC = WinningRank.getSortedListByRankASC();
        int prevRank = -1;
        for (WinningRank winningRank : sortedListByRankASC) {
            Integer currRank = winningRank.getRank();
            assertThat(currRank).isGreaterThan(prevRank);
        }
    }
}

