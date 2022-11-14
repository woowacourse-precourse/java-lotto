package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PayTest {
    @DisplayName("구매수량 입력시 숫자 이외 다른 것을 입력하면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Pay = {0}")
    @ValueSource(strings = {"1,000", " 1000", "1 000", "10 00", "10r0", "4---", "", " ", "....", "12<000"})
    void purchaseLottoQtyCheckInput(String input) {
        assertThatThrownBy(() -> new Pay(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매수량 입력 시 1000원 단위로 입력하지 않을 시 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Pay = {0}")
    @ValueSource(strings = {"132300", "150300", "100030", "123999"})
    void purchaseLottoQtyCheckReminder(String input) {
        assertThatThrownBy(() -> new Pay(input)).isInstanceOf(IllegalArgumentException.class);
    }
}