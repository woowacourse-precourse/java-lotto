package lotto.domain;

import constants.ExceptionMessage;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 ~ 45 범위에 해당하지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNotWithinRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WITHIN_RANGE);
    }

    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    @Test
    void sortAscendingLottoNumber() {
        List<Integer> lottoNumbers = Arrays.asList(5,9,2,23,14,44);
        Lotto lotto = new Lotto(lottoNumbers);

        lotto.sortAscending();
        assertThat(lotto.toString()).isEqualTo("[2, 5, 9, 14, 23, 44]");
    }

    @DisplayName("보너스 번호가 존재하지 않으면 false를 반환한다.")
    @Test
    void checkBonusNumberNotInLotto() {
        BonusBall bonusBall = new BonusBall(7);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        boolean isMatchBonusNumber = lotto.matchBonusBall(bonusBall);

        assertFalse(isMatchBonusNumber);
    }

    @DisplayName("보너스 번호가 존재하면 true를 반환한다.")
    @Test
    void checkBonusNumberInLotto() {
        BonusBall bonusBall = new BonusBall(7);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));

        boolean isMatchBonusNumber = lotto.matchBonusBall(bonusBall);

        assertTrue(isMatchBonusNumber);
    }

    @DisplayName("당첨번호 3개를 맞추면 5등 결과를 반환한다.")
    @Test
    void checkRank5th() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusNubmer = new BonusBall(7);
        Balls balls = new Balls(winningBalls,bonusNubmer);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,8,9,10));

        Match match = lotto.match(balls);

        assertThat(match).isEqualTo(Match.THREE_MATCH);
    }

    @DisplayName("당첨번호 4개를 맞추면 4등 결과를 반환한다.")
    @Test
    void checkRank4th() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusNubmer = new BonusBall(7);
        Balls balls = new Balls(winningBalls,bonusNubmer);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,8,9));

        Match match = lotto.match(balls);

        assertThat(match).isEqualTo(Match.FOUR_MATCH);
    }

    @DisplayName("당첨번호 5개를 맞추면 3등 결과를 반환한다.")
    @Test
    void checkRank3rd() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusNubmer = new BonusBall(7);
        Balls balls = new Balls(winningBalls,bonusNubmer);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));

        Match match = lotto.match(balls);

        assertThat(match).isEqualTo(Match.FIVE_MATCH);
    }

    @DisplayName("당첨번호 5개, 보너스 번호를 맞추면 2등 결과를 반환한다.")
    @Test
    void checkRank2nd() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusNubmer = new BonusBall(7);
        Balls balls = new Balls(winningBalls,bonusNubmer);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));

        Match match = lotto.match(balls);

        assertThat(match).isEqualTo(Match.FIVE_BONUS_MATCH);
    }

    @DisplayName("당첨번호 6개를 맞추면 1등 결과를 반환한다.")
    @Test
    void checkRank1st() {
        WinningBalls winningBalls = new WinningBalls(Arrays.asList(1,2,3,4,5,6));
        BonusBall bonusNubmer = new BonusBall(7);
        Balls balls = new Balls(winningBalls,bonusNubmer);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Match match = lotto.match(balls);

        assertThat(match).isEqualTo(Match.SIX_MATCH);
    }

}
