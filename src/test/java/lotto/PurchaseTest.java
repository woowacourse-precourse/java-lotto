package lotto;

import lotto.management.Purchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {

    @ParameterizedTest
    @DisplayName("금액에 따른 로또 티켓 갯수 확인 테스트")
    @ValueSource(strings = {"5000", "10000", "50000"})
    void checkTotalAmount(String amount) {
        Purchase purchase = new Purchase(amount);
        Assertions.assertEquals(Integer.parseInt(amount) / Purchase.LOTTO_PRICE,
                purchase.getNumberOfLottoTickets());
    }

    @ParameterizedTest
    @DisplayName("구입 금액을 숫자로 입력 ")
    @ValueSource(strings = {"1000", "2000", "3000", "4000"})
    void checkNumber(String input) {
        assertThatCode(
                () -> Purchase.isNumber(input)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("구입 금액을 숫자로 입력 x")
    @ValueSource(strings = {"abcd", "qwer", "모에모에", "뀨"})
    void checkNotNumber(String input) {
        assertThatThrownBy(
                () -> Purchase.isNumber(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입 금액 천원 단위")
    @ValueSource(strings = {"1000", "5000", "10000"})
    void checkAmountInputTest(String input) {
        assertThatCode(
                () -> Purchase.validDivide(input)
        ).doesNotThrowAnyException();
    }


    @ParameterizedTest
    @DisplayName("구입 금액 천원 단위 X")
    @ValueSource(strings = {"1001", "2030", "3456"})
    void checkThousandDivide(String input) {
        assertThatThrownBy(
                () -> Purchase.validDivide(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
