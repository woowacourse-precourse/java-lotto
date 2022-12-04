package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoAmountTest {

    @Test
    @DisplayName("로또 구매 금액이 1000원 미만일 때 예외")
    void validateMinimumAmount() {
        assertThatThrownBy(() -> new LottoAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 구매 금액이 1000원이 넘고 1000원으로 나누어 떨어지지 않을 때 예외")
    @ValueSource(ints = {1001, 10001, 2222})
    void validateAmountUnit(int amount) {
        assertThatThrownBy(() -> new LottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 구매 금액 1000원 단위로 들어왔을 때 로또 개수 확인")
    @CsvSource(value = {
            "1000,1",
            "10000,10",
            "500000,500"
    })
    void makeLottoTickets(int amount, int lottoTickets) {
        LottoAmount lottoAmount = new LottoAmount(amount);

        assertThat(lottoAmount.makeLottoTickets()).isEqualTo(lottoTickets);
    }
}
