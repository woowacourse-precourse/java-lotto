package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import constants.ExceptionMessage;
import java.util.Arrays;
import lotto.domain.dto.MatchResultDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

    @DisplayName("보너스 번호가 당첨번호에 존재할 경우 예외 발생")
    @Test
    void createBonusNumberDuplicate() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(6);

        assertThatThrownBy(() -> new Balls(winningBalls, bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.CONTAIN_BONUS);
    }

    @DisplayName("보너스 번호가 당첨번호에 존재하지 않을 경우 정상진행")
    @Test
    void createBonusNumberNotDuplicate() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);

        assertThatCode(() -> new Balls(winningBalls, bonusBall))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 매칭 (5등 매칭된 번호가 3개인 경우)")
    @Test
    void checkRank5thDto() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls = new Balls(winningBalls, bonusBall);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));

        MatchResultDTO matchResult = balls.matching(lotto);

        assertThat(matchResult.getMatchCount()).isEqualTo(3);
    }

    @DisplayName("로또 번호 매칭 (4등 : 매칭된 번호가 4개인 경우)")
    @Test
    void checkRank4thDto() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls = new Balls(winningBalls, bonusBall);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10));

        MatchResultDTO matchResult = balls.matching(lotto);

        assertThat(matchResult.getMatchCount()).isEqualTo(4);
    }

    @DisplayName("로또 번호 매칭 (3등 : 매칭된 번호가 5개인 경우)")
    @Test
    void checkRank3rdDto() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls = new Balls(winningBalls, bonusBall);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));

        MatchResultDTO matchResult = balls.matching(lotto);

        assertThat(matchResult.getMatchCount()).isEqualTo(5);
    }

    @DisplayName("로또 번호 매칭 (2등 : 매칭된 번호가 5개+보너스인 경우)")
    @Test
    void checkRank2ndDto() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls = new Balls(winningBalls, bonusBall);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));

        MatchResultDTO matchResult = balls.matching(lotto);

        assertThat(matchResult.getMatchCount()).isEqualTo(5);
        assertTrue(matchResult.isMatchBonus());
    }

    @DisplayName("로또 번호 매칭 (1등 : 매칭된 번호가 6개인 경우)")
    @Test
    void checkRank1stDto() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = new BonusBall(7);
        Balls balls = new Balls(winningBalls, bonusBall);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        MatchResultDTO matchResult = balls.matching(lotto);

        assertThat(matchResult.getMatchCount()).isEqualTo(6);
    }

}