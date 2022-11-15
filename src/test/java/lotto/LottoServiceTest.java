package lotto;

import lotto.service.LottoService;
import lotto.util.ArgumentExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/15
 */
public class LottoServiceTest {
    @DisplayName("구매 금액이 로또 구매금액으로 나누어 떨어지 않는 경우, 예외가 발생한다.")
    @Test
    void divideLottoPriceByNotMultipleLottoPrice() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toPurchaseAmount("9100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_PURCHASE_AMOUNT_UNCONFORMABLE_VALUE.getMessage());
    }

    @DisplayName("구매 금액이 정수가 아닌 경우, 예외가 발생한다.")
    @Test
    void divideLottoPriceByNotInteger() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(() -> lottoService.toPurchaseAmount("900a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ArgumentExceptionMessage.INPUT_NOT_INTEGER.getMessage());
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지는 경우 정상 동작한다.")
    @Test
    void  divideLottoPrice() {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.toPurchaseAmount("9000")).isEqualTo(9);
    }
}
