package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CostTest {
    @DisplayName("구매 금액에 문자가 포함되면 예외가 발생합니다.")
    @Test
    void createCostWithCharacters() {
        assertThatThrownBy(() -> new Cost("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아니라면 예외가 발생합니다.")
    @Test
    void createLottoWithInvalidUnit() {
        assertThatThrownBy(() -> new Cost("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}