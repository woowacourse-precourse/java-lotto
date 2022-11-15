package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호를 쉼표로 구분되는 6개의 수로 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호엔 중복된 숫자가 없어야 합니다.");
    }

    @DisplayName("set 메소드를 통해 당첨 번호가 numberType 변수에 세팅된다.")
    @Test
    void setWinningNumber() {
        initializeNumberType();
        ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 45));
        new Lotto(winningNumbers);
        for (int number = 1; number <= 45; number++) {
            if (winningNumbers.contains(number)) {
                assertThat(numberType[number]).isEqualTo(NumberType.WINNING);
                continue;
            }
            assertThat(numberType[number]).isNotEqualTo(NumberType.WINNING);
        }
    }

    @DisplayName("로또 번호가 1이상 45이하의 자연수가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfValidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(46, 1, 5, 8, 27, 32)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }
}