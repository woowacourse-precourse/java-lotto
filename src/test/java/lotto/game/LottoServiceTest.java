package lotto.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("입력된 금액이 숫자가 아니면 에외가 발생한다.")
    void createMoneyByNotInteger() {
        // given
        String input = "12삼";
        // expect
        assertThatThrownBy(() -> lottoService.convertInputToMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("입력된 금액이 1000으로 나눠떨어지지 않으면 예외가 발생한다")
    void createMoneyByNotDivisible1000() {
        // given
        String input = "12345";
        assertThatThrownBy(() -> lottoService.convertInputToMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000으로 나눠 떨어지는 금액만 입력해주세요.");
    }

    @Test
    @DisplayName("입력된 금액이 정상적이면 돈을 반환한다.")
    void createMoney() {
        // given
        String input = "10000";
        Money money = Money.of(10000);

        // expect
        assertThat(lottoService.convertInputToMoney(input))
                .isEqualTo(money);
    }
}