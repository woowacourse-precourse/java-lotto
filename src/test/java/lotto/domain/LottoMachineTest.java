package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMachineTest {

    @DisplayName("로또 구입 금액이 숫자 외 문자가 입력되면 에러가 발생한다.")
    @Test
    void createPurchasePriceByNotInType() {
        assertThatThrownBy(() -> new LottoMachine(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_PRICE_TYPE.getMessage());
    }

    @DisplayName("로또 구입 금액이 1,000 단위 수가 아니면 에러가 발생한다.")
    @Test
    void createPurchasePriceByNotInUnit() {
        assertThatThrownBy(() -> new LottoMachine("8080"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_PRICE_UNIT.getMessage());
    }

    @DisplayName("로또 구입 금액이 1,000 미만의 수가 입력되면 에러가 발생한다.")
    @Test
    void createPurchasePriceByUnderRange() {
        assertThatThrownBy(() -> new LottoMachine("800"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_PRICE_RANGE.getMessage());
    }
}
