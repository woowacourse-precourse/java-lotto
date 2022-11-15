package domain;

import domain.Money.Money;
import domain.Money.MoneyController;
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
        assertThatThrownBy(() ->  moneyController.createMoney("1000 1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 공백이 포함되지 않은 자연수 하나만 입력해야 합니다.");
    }

    @Test
    void 금액_형식_예외_테스트2() {
        assertThatThrownBy(() ->  moneyController.createMoney("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 공백이 포함되지 않은 자연수 하나만 입력해야 합니다.");
    }
}
