package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverSize() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 이미 존재하는 보너스 번호이면 예외가 발생한다.")
    @Test
    void isAlreadyExistenceBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 1~45의 숫자가 아니라 예외가 발생한다.")
    @Test
    void createLottoByRangeOfNumber() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 47))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 몇개의 숫자가 일치하는가")
    @Test
    void howManyMatchingCount() {
        int num = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 8)
                .matchCount(new Lotto(List.of(3, 4, 5, 6, 7, 8)));

        Assertions.assertEquals(4, num);
    }

    @DisplayName("보너스 번호를 포함하는가")
    @Test
    void isContainsBonusNumber() {
        boolean containsBonusNumber = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 8)
                .isContainsBonusNumber(new Lotto(List.of(3, 4, 5, 6, 7, 8)), 9);

        Assertions.assertEquals(false, containsBonusNumber);
    }
}