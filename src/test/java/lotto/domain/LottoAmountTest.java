package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoAmountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1100, -1})
    @DisplayName("올바르지 않은 금액일 경우 예외가 발생한다.")
    void failed(int input) {
        assertThatThrownBy(() -> new LottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매한 로또의 개수를 정상 반환한다.")
    void calculateLottoCount() {
        LottoAmount amount = new LottoAmount(1000);
        assertThat(amount.calculateLottoCount()).isEqualTo(1);
    }
}