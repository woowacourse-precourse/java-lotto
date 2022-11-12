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
    @DisplayName("입력된 구입 금액이 양수가 아니거나 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-12", "0", "-12345", "12345", "123"})
    void createMoneyNotPositive(String number) {
        assertThatThrownBy(
                () -> user.checkThatPurchaseMoneyIsRightInput(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}