package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserTest {
    User user = new User();
    @DisplayName("입력된 구입 금액이 0보다 작거나 같으면 예외가 발생한다.")
    @Test
    void createMoneyNotPositive() {
        assertThatThrownBy(
                () -> user.checkThatPurchaseMoneyIsRightInput("-12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyNotMultipleOfThousand() {
        assertThatThrownBy(
                () -> user.checkThatPurchaseMoneyIsRightInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입 금액에 맞게 로또를 구매하는지 확인")
    @Test
    void createMoneyAndLotto() {
        user.money = 8000;
        user.purchaseLotto();
        assertThat(user.myLotto.size()).isEqualTo(8);
    }

}