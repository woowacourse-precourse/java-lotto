package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("당첨번호와 맞는 로또번호의 개수를 반환한다")
    @Test
    void countMatchedNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        int count = 6;

        // when
        WinningNumber winningNumber = new WinningNumber(numbers, bonus);

        // then
        assertThat(winningNumber.countMatchedNumbers(numbers)).isEqualTo(count);

    }

    @DisplayName("길이가 맞지 않는 당첨번호에는 예외를 던진다")
    @Test
    void createWinningNumberByOversize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int bonus = 8;

        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외를 던진다")
    @Test
    void createOverlappingBonus() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 3;

        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}