package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @DisplayName("로또 구입 금액이 0보다 작을 경우 예외가 발생한다.")
    @Test
    void inputPurchaseMoneyUnderZero() {
        assertThatThrownBy(() -> new User(-1000,
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void inputPurchaseMoneyNotDividedThousand() {
        assertThatThrownBy(() -> new User(13400,
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("8,000원어치 로또를 산 후 5,000원에 당첨되면 수익률은 62.5퍼센트이다.")
    @Test
    void incomePercentTest() {
        User user = new User(8000,
                List.of(new Lotto(List.of(1, 2, 3, 43, 44, 45))),
                new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7));
        float incomePercent = user.getIncomePercent();

        assertThat(incomePercent).isEqualTo(62.5f);
    }
}