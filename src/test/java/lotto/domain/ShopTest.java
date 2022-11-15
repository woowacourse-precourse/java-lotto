package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ShopTest {
    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @DisplayName("유효하지 않은 구입금액 예외 처리 확인")
    @ParameterizedTest
    @CsvSource({"500", "1200", "3100"})
    void invalidMoney(int money) {
        assertThatThrownBy(() -> shop.buyLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 구입금액 정상 작동 확인")
    @ParameterizedTest
    @CsvSource({"2000", "5000", "14000"})
    void validMoney(int money) {
        assertThatCode(() -> shop.buyLottos(money))
                .doesNotThrowAnyException();
    }
}