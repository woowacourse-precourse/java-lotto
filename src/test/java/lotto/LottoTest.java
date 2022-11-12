package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 복권번호는 6자리 숫자입니다.");
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void createLottoBySmallSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 복권번호는 6자리 숫자입니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 복권번호가 있습니다.");
    }

    @DisplayName("로또 번호에 잘못된 범위의 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1, 2, 3, 46, 5, 6", "1, 2, 3, 0, 5, 6"})
    void createLottoByOverRangeNumber(int number1, int number2, int number3, int number4, int number5, int number6) {
        assertThatThrownBy(() -> new Lotto(List.of(number1, number2, number3, number4, number5, number6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("정상적으로 로또 번호가 생성된다")
    @ParameterizedTest
    @CsvSource({"1, 17, 9, 23, 6, 43", "44, 43, 10, 20, 30, 45"})
    void createLotto(int number1, int number2, int number3, int number4, int number5, int number6) {
        boolean result = true;
        try {
            new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }
}
