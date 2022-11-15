package lotto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserInputValidationTest {
    private UserInputValidation userInputValidation;

    @BeforeEach
    void setup() {
        this.userInputValidation = new UserInputValidation();
    }


    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(strings = {"1z1", "q", "%", "+", " "})
    @DisplayName("숫자가 아닌지 확인")
    void inputCharacter(String userInput) {
        assertThatThrownBy(() -> this.userInputValidation.checkIsNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(ints = {1, 20, 1001})
    @DisplayName("1000단위 인지 확인")
    void inputBuyLotto(int amount) {
        assertThatThrownBy(() -> this.userInputValidation.checkBuyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("숫자 6개인지 확인(구분자는 쉼표)")
    void inputCorrectCount(String userInput) {
        assertThatThrownBy(() -> this.userInputValidation.checkCorrectCount(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(ints = {0, -1, 46, 47})
    @DisplayName("1~45 사이의 수인지 확인")
    void inputValidNumber(int number) {
        assertThatThrownBy(() -> this.userInputValidation.checkInvalidNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(strings = {"", " ", "\t", "\n"})
    @DisplayName("공백 확인(해당 메소드 값을 주기 전 replaceAll을 함)")
    void inputWithWhiteSpace(String userInput) {
        String finalUserInput = userInput.replaceAll("\\s", "");
        assertThatThrownBy(() -> this.userInputValidation.checkWhiteSpace(finalUserInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}