package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @DisplayName("구입 금액에 따라 복권 수량을 계산한다")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "15000, 15"})
    void 구매_가능한_복권_수량_계산(int amount, int num) {
        assertThat(new Money(amount).getNumberOfLottos()).isEqualTo(num);
    }

    @Test
    void 구매_금액_1000단위가_아니면_예외던지기() {
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 구매_금액_0원보다_작으면_예외던지기() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}