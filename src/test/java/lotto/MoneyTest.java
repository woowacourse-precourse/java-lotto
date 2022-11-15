package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("입력된 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByCharacter() {
        assertThatThrownBy(() -> new Money("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyByDivide1000() {
        assertThatThrownBy(() -> new Money("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("옳바른 금액이 입력되어 구매 가능한 로또의 갯수가 반환되는지 확인한다.")
    @Test
    void createQuotientByMoney() {
        Money money = new Money("13000");
        assertThat(money.getLottoCount()).isEqualTo(13);
    }
}