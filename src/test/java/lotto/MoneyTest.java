package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("입력한 돈이 1000으로 나뉘어지지 않으면 예외가 발생한다.")
    @Test
    void checkDuplicatedNumber() {
        assertThatThrownBy(() -> new Money("3001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 돈이 숫자가 아닌 경우 예외가 발생한다..")
    @Test
    void checkBonusNumber() {
        assertThatThrownBy(() -> new Money("300j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 돈이 1000원 미만인 경우 예외가 발생한다.")
    @Test
    void createLottoByChar() {
        assertThatThrownBy(() -> new Money("300"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력이 잘 되는지 확인")
    @Test
    void inputMoney() {
        Money money =  new Money("4000");

        int result = 4;

        assertThat(money.getMoney()).isEqualTo(result);
    }
}
