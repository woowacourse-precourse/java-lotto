package domain;

import MoneyController;
import domain.Money.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    MoneyController moneyController = new MoneyController();

    @Test
    void 금액_단위_예외_테스트1() {
        assertThatThrownBy(() -> new Money(9500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 금액_단위_예외_테스트2() {
        assertThatThrownBy(() -> new Money(12345))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 금액_형식_예외_테스트1() {
        assertThatThrownBy(() ->  moneyController.getPurchaseAmount("1000 1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 숫자여야 합니다.");
    }

    @Test
    void 금액_형식_예외_테스트2() {
        assertThatThrownBy(() ->  moneyController.getPurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 숫자여야 합니다.");
    }
}
