package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("쉼표를 기준으로 나누었을때 숫자가 아니면 예외처리를 한다.")
    @Test
    void createPickLottoByNotNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,a,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표를 기준으로 나누었을때 숫자가 6개가 아니면 예외처리를 한다.")
    @Test
    void createPickLottoByNotLength() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표를 기준으로 나눈 숫자가 숫자 범위 1~45 사이에 없으면 예외처리를 한다.")
    @Test
    void createPickLottoByNotRange() {
        assertThatThrownBy(() -> new WinningNumbers("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,46,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("쉼표를 기준으로 나눈 숫자가 중복되면 예외처리를 한다.")
    @Test
    void createPickLottoByDuplicate() {
        assertThatThrownBy(() -> new WinningNumbers("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상일 때")
    @Test
    void createPickLottoByNumber() {
        assertThatCode(() -> { new WinningNumbers("1,2,3,4,5,6"); }).doesNotThrowAnyException();
    }
}
