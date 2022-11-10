package lotto;

import lotto.exception.Exception;
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

    @DisplayName("구입 금액에 숫자가 아닌 문자가 섞여있을 때 예외 발생")
    @Test
    void verifyMoneyNumberFormat() {
        assertThatThrownBy(() -> Exception.verifyMoney("1000q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이나 1000으로 나누어 떨어지지 않을 때")
    @Test
    void verifyMoney() {
        assertThatThrownBy(() -> Exception.verifyMoney("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Exception.verifyMoney("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
