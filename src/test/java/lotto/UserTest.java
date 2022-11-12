package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserTest {
    @DisplayName("입력된 구입 금액이 0보다 작거나 같으면 예외가 발생한다.")
    @Test
    void createMoneyNotPositive() {
        assertThatThrownBy(
                () -> User.checkThatPurchaseMoneyIsRightInput("-12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyNotMultipleOfThousand() {
        assertThatThrownBy(
                () -> User.checkThatPurchaseMoneyIsRightInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}