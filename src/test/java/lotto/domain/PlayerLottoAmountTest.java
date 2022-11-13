package lotto.domain;

import org.junit.jupiter.api.DisplayName;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerLottoAmountTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 1100, -1})
    @DisplayName("올바르지 않은 금액")
    void failed(int inputAmount) {
        assertThatThrownBy(() -> new PlayerLottoAmount(inputAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}