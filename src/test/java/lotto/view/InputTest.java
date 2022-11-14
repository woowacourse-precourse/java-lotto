package lotto.view;

import lotto.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @Test
    @DisplayName("구매금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
    void getLottoCount() {
        assertThatThrownBy(() -> Input.validateAmount(30050))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName(",로 구분된 숫자가 아니면 예외가 발생한다.")
    void inputWinNumbersException() {
        assertThatThrownBy(() -> Input.getIntegerList("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적으로 숫자를 입력받은 경우, Integer 리스트를 반환한다.")
    void inputWinNumbers() {
        List<Integer> numbers = Input.getIntegerList("1,2,3,4,5,6");
        assertThat(numbers.size()).isEqualTo(6);
        for (int i = 0; i < 6; i++) {
            assertThat(numbers.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("보너스 번호는 숫자 입력이어야 한다.")
    void inputBonusNumberNotNumber() {
        assertThatThrownBy(() -> Input.getInteger("hi", "[ERROR] 보너스 번호는 숫자여야 합니다."))
                .isInstanceOf(IllegalArgumentException.class);
    }
}