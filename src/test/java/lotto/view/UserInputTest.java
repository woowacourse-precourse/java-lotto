package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserInputTest {
    @DisplayName("빈 문자열이 들어가면 에러가 발생한다.")
    @Test
    void validateInputMoneyTest1() {
        assertThatThrownBy(() -> {
            UserInput userInput = new UserInput();
            userInput.inputMoney();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자가 들어가면 에러가 발생한다.")
    @Test
    void validateInputMoneyTest2() {
        assertThatThrownBy(() -> {
            validateInputMoney("1000a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 숫자가 들어가면 에러가 발생한다.")
    @Test
    void validateInputMoneyTest3() {
        assertThatThrownBy(() -> {
            validateInputMoney("1001");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어 떨어지는 숫자가 들어가면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "34234234000", "234000"})
    void validateInputMoneyTest4(String string) {
        assertThatCode(() -> {
            validateInputMoney(string);
        }).doesNotThrowAnyException();
    }

    private static void validateInputMoney(String inputMoney) {
        if (!inputMoney.matches("^[0-9]+000$")) {
            throw new IllegalArgumentException();
        }
    }
}
