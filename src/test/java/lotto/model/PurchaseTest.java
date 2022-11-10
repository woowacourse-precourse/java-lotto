package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PurchaseTest {

    private static final Purchase purchase= new Purchase();


    @DisplayName("사용자가 지불한 금액을 로또의 개수로 바꿔준다.")
    @Test
    void changeToLotto() {
        String moneyInput = "14000";

        int numberOfLotto = purchase.changeToLotto(moneyInput);

        Assertions.assertThat(numberOfLotto).isEqualTo(14);
    }

    @DisplayName("사용자가 지불한 금액에 대한 입력이 숫자가 아닌경우 예외가 발생한다.")
    @Test
    void changeToLottoByNotNumberMoney() {
        String moneyInput = "1a000";

        assertThatThrownBy(() -> purchase.changeToLotto(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 지불한 금액이 0원인 경우 예외가 발생한다.")
    @Test
    void changeToLottoByZeroWon() {
        String moneyInput = "000";

        assertThatThrownBy(() -> purchase.changeToLotto(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 지불한 금액이 1000원 보다 작을 경우 예외가 발생한다.")
    @Test
    void changeToLottoByLessThanThousandWon() {
        String moneyInput = "100";

        assertThatThrownBy(() -> purchase.changeToLotto(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 지불한 금액이 1000원단위로 끊기지 않을 경우 예외가 발생한다.")
    @Test
    void changeToLottoByNotMultipleOfThousand() {
        String moneyInput = "120001";

        assertThatThrownBy(() -> purchase.changeToLotto(moneyInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}