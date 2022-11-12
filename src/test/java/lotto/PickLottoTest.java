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

    @DisplayName("쉼표를 기준으로 나눈 숫자가 숫자 범위 1~45 사이에 없으면 예외처리를 한다.")
    @Test
    void createPickLottoByNotRange() {
        assertThatThrownBy(() -> new PickLotto("0,1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PickLotto("1,2,3,46"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("쉼표를 기준으로 나눈 숫자가 중복되면 예외처리를 한다.")
    @Test
    void createPickLottoByDuplicate() {
        assertThatThrownBy(() -> new PickLotto("1,1,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상일 때")
    @Test
    void createPickLottoByNumber() {
        assertThatCode(() -> { new PickLotto("1,2,3"); }).doesNotThrowAnyException();
    }
}
