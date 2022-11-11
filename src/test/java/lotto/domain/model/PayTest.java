package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayTest {
    @DisplayName("구매수량 입력시 숫자 이외 다른 것을 입력하면 예외가 발생한다.")
    @Test
    void purchaseLottoQtyCheckInput() {

        assertThatThrownBy(() -> new Pay("1,000")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매수량 입력 시 1000원 단위로 입력하지 않을 시 예외가 발생한다.")
    @Test
    void purchaseLottoQtyCheckReminder() {

        assertThatThrownBy(() -> new Pay("150300")).isInstanceOf(IllegalArgumentException.class);
    }
}