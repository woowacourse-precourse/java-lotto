package lotto;

import lotto.io.Input;
import lotto.utils.ValidateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위 내 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(132, 21, 34, 24, 5, 56)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈의 범위가 1000단위가 아니라면 예외가 발생한다.")
    @Test
    void inputUserPayByUnit() {
        assertThatThrownBy(() -> ValidateUtils.checkMoneyUnit(2340))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시, ',' 구분자를 사용하지 않으면 발생한다.")
    @Test
    void inputUserLottoNumber() {
        assertThatThrownBy(() -> ValidateUtils.checkDelimiter(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void inputUserString() {
        assertThatThrownBy(() -> ValidateUtils.checkTypeNumber("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
