package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 발행된 로또를 비교하는 기능")
    @Test
    void compareWithWinningNumbersTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        int count = lotto.compareWithWinningNumbers(winningNumbers);

        assertThat(count).isEqualTo(3);
    }

    @Nested
    @DisplayName("보너스번호와 발행된 로또를 비교하는 기능")
    class compareWithBonusNumber {

        @DisplayName("보너스번호를 맞췄을 때")
        @Test
        void win() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            boolean isBonusNumberRight = lotto.compareWithBonusNumber(6);

            assertThat(isBonusNumberRight).isEqualTo(true);
        }

        @DisplayName("보너스번호를 못 맞췄을 때")
        @Test
        void lose() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            boolean isBonusNumberRight = lotto.compareWithBonusNumber(7);

            assertThat(isBonusNumberRight).isEqualTo(false);
        }
    }


}
