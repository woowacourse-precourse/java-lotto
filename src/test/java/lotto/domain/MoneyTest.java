package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {

    @DisplayName("금액 생성시 천 단위가 아니면 예외 발생해야 함")
    @ParameterizedTest
    @CsvSource({
            "1", "123", "1001", "10000123", "94", "999", "10", "100"
    })
    void createMoneyByNotThousandUnit(int input) {
        assertThatThrownBy(() -> {
            Money money = new Money(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 생성시 0이면 예외 발생해야 함")
    @Test
    void createMoneyByNotThousandUnit() {
        assertThatThrownBy(() -> {
            Money money = new Money(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 생성시 음수이면 예외 발생해야 함")
    @Test
    void createMoneyByNegative() {
        assertThatThrownBy(() -> {
            Money money = new Money(-1000);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("금액에 상태가 천단위 콤마로 이루어진 문자열 출력애야함")
    @Test
    void getMoneyFormat() {
        // given
        Money money = new Money(10000);

        // when
        String result = money.getMoneyFormat();

        // then
        assertThat(result).isEqualTo("10,000");
    }
}