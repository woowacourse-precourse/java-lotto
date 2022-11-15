package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PurchaseTest {

    private static final Purchase purchase = new Purchase();


    @DisplayName("사용자가 지불한 금액을 로또의 개수로 바꿔준다.")
    @Test
    void changeToLotto() {
        int moneyInput = 1000;

        int numberOfLotto = purchase.changeToLotto(moneyInput);

        Assertions.assertThat(numberOfLotto).isEqualTo(1);
    }

    @DisplayName("사용자가 지불한 금액이 입력 요구 사항에 맞지 않을 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"000","100","12001","110000"})
    void changeToLottoByNotNumberMoney(int money) {
        assertThatThrownBy(() -> purchase.changeToLotto(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}