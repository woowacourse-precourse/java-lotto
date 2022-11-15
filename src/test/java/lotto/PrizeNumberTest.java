package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.message.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeNumberTest {

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void prizeNumberByOverSize() {
        assertThatThrownBy(() -> new PrizeNumber(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SIZE_EXCEPTION);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다.")
    void prizeNumberByUnderSize() {
        assertThatThrownBy(() -> new PrizeNumber(List.of(1, 2, 3, 4, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(SIZE_EXCEPTION);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void prizeNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new PrizeNumber(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION);
    }

    @Test
    @DisplayName("당첨 번호가 1~45 이외의 숫자라면 예외가 발생한다.")
    void prizeNumberByNumbersOutOfRange() {
        assertThatThrownBy(() -> new PrizeNumber(List.of(1, 2, 3, 4, 5, 100), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE_EXCEPTION);
    }

    @Test
    @DisplayName("보너스 번호가 1~45 이외의 숫자라면 예외가 발생한다.")
    void prizeNumberByBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new PrizeNumber(List.of(1, 2, 3, 4, 5, 6), 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(OUT_OF_RANGE_EXCEPTION);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외가 발생한다.")
    void prizeNumberByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new PrizeNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION);
    }
}