package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService;
    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외 발생")
    @Test
    void getLottosByNotIntMoney() {
        assertThatThrownBy(() -> lottoService.getLottos("123j4n"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 0원일 경우 예외 발생")
    @Test
    void getLottosByZeroMoney() {

        assertThatThrownBy(() -> lottoService.getLottos("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않을 경우 예외 발생")
    @Test
    void getLottosByInvalidMoney() {

        assertThatThrownBy(() -> lottoService.getLottos("1230"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}