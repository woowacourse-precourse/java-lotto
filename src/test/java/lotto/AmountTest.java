package lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AmountTest {

    Amount amount;

    @BeforeEach
    void amountInit() {
        amount = new Amount("10000");
    }

    @Test
    @DisplayName("구입 금액에 맞는 로또 개수인지 Test")
    void correctCount() {
        assertThat(amount.calculateBallCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자만 입력하지 않은 경우 예외가 발생한다.")
    void notValidInput() {
        assertThrows(IllegalArgumentException.class, () -> amount = new Amount("10000A"));
    }

    @Test
    @DisplayName("1000원 단위로 입력하지 않은 경우 예외가 발생한다.")
    void notValidUnit() {
        amount = new Amount("10500");
        assertThrows(IllegalArgumentException.class, () -> amount.calculateBallCount());
    }
}
