package lotto.domain;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Calculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("구매 횟수가 알맞지 않은 경우 예외가 발생한다.")
    @Test
    void 구매횟수_예외발생() {
        assertThat(Calculator.getQuantity("8000")).isEqualTo(8);
    }
}
