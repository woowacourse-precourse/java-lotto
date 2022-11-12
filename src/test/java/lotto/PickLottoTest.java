package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PickLottoTest {
    @DisplayName("쉼표를 기준으로 나누었을때 숫자가 아니면 예외처리를 한다.")
    @Test
    void createPickLottoByNotNumber() {
        assertThatThrownBy(() -> new PickLotto("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("쉼표를 기준으로 나누었을때 숫자이면 정상이다.")
    @Test
    void createPickLotto() {
        assertThatCode(() -> { new PickLotto("1,2,3"); }).doesNotThrowAnyException();
    }
}
