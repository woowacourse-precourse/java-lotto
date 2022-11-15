package domain;

import lotto.domain.LottoPurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {

    @Test
    @DisplayName("로또 구입금액이 0원이면 예외가 발생한다.")
    void inputMoneyEqualsWithZero() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {500, 999, 1001})
    void inputMoneyNotDividedByThousand(int amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000 단위로 입력되었을 경우 로또 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1000, 1",
            "2000, 2",
            "8000, 8"
    })
    void calculateNumberOfLottoTickets(int amount, int numberOfTickets) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount);
        assertThat(lottoPurchaseAmount.calculateNumberOfLottoTickets()).isEqualTo(numberOfTickets);
    }
}
