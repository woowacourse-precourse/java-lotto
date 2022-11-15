package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개보다 적다면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하면, 해당 Score를 반환한다.")
    @Test
    void compareLottoWithWinningNumbers() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 6, 7, 8));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 45), 10);

        Score score1 = lotto1.compareWithWinningNumbers(winningNumbers);
        Score score2 = lotto2.compareWithWinningNumbers(winningNumbers);
        Score score3 = lotto3.compareWithWinningNumbers(winningNumbers);

        Assertions.assertEquals(Score.SIX, score1);
        Assertions.assertEquals(Score.THREE, score2);
        Assertions.assertEquals(Score.FIVE, score3);
    }

    @DisplayName("5개 번호와 보너스 번호가 일치하면, FIVE_BONUS를 반환한다.")
    @Test
    void compareLottoWithWinningNumbersFiveBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 10), 45);

        Score score = lotto.compareWithWinningNumbers(winningNumbers);

        Assertions.assertEquals(Score.FIVE_BONUS, score);
    }

    @DisplayName("로또 번호가 3개 미만 일치하면, NOTHING을 반환한다.")
    @Test
    void compareLottoWithWinningNumbersNothing() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 10, 11, 12, 13), 45);

        Score score = lotto.compareWithWinningNumbers(winningNumbers);

        Assertions.assertEquals(Score.NOTHING, score);
    }
}
