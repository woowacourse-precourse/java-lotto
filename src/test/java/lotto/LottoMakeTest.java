package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoMakeTest {
    static Purchase purchase;

    @BeforeAll
    static void initLotto() {
        purchase = new Purchase("1000");
    }

    @DisplayName("로또 구입 금액이 1000원 단위면 문제 없이 생성된다")
    @ValueSource(strings = {"1000", "20000", "99000"})
    @ParameterizedTest
    void checkPurchaseNotUnit(String input) {
        assertDoesNotThrow(() -> new Purchase(input));
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니라면 예외가 발생한다")
    @ValueSource(strings = {"100", "2222", "9900"})
    @ParameterizedTest
    void checkPurchaseUnit(String input) {
        assertThatThrownBy(() -> purchase.validatePurchaseUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 숫자외의 값이라면 예외가 발생한다")
    @ValueSource(strings = {"aa", "bb", "*"})
    @ParameterizedTest
    void checkPurchaseNumber(String input) {
        assertThatThrownBy(() -> purchase.validatePurchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
