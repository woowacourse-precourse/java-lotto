package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("로또 구입 금액이 입력되지 않으면 에러가 발생한다.")
    @Test
    void createPurchasePriceByEmpty() {
        assertThatThrownBy(() -> new LottoMachine(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 구입 금액이 입력되면 구입 금액을 정상적으로 리턴한다.")
    @ParameterizedTest
    @CsvSource({"8000,8000", "10000,10000", "25000,25000"})
    void createRightPurchasePrice(String purchasePrice, int expected) {
        LottoMachine lottoMachine = new LottoMachine(purchasePrice);
        assertThat(lottoMachine.getPurchasePrice()).isEqualTo(expected);
    }

    @DisplayName("올바른 구입 금액이 입력되면 발행 회차를 정상적으로 리턴한다.")
    @ParameterizedTest
    @CsvSource({"8000,8", "10000,10", "25000,25"})
    void createRightRound(String purchasePrice, int expected) {
        LottoMachine lottoMachine = new LottoMachine(purchasePrice);
        assertThat(lottoMachine.getRound()).isEqualTo(expected);
    }
}
