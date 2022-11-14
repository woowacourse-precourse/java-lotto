package lotto;

import lotto.domain.Lotto;
import lotto.exception.InputException;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    /*
    로또 금액 입력 예외
     */

    @DisplayName("로또 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoAmountByOnlyNumber() {
        String amount = "190k";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoAmountByDivisible() {
        String amount = "1900";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createLottoAmountByMoreThan() {
        String amount = "900";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*
    로또 금액 입력 예외
     */

}
