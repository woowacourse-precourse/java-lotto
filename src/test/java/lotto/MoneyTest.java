package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("숫자 이외의 입력이 들어오면 예외가 발생한다.")
    void createNotNumberMoney() {
        assertThatThrownBy(() -> new Money("A1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 금액이 1000원의 배수가 아니면 예외가 발생한다.")
    void createNotMultipleOf1000() {
        assertThatThrownBy(() -> new Money("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 금액이 로또 구매 금액보다 낮으면 예외가 발생한다.")
    void createCannotPurchaseMoney() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
