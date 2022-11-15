package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserInputValidationTest {
    private static final UserInputValidation userInputValidation = new UserInputValidation();

    @DisplayName("숫자가 아닌지 확인")
    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(strings = {"1z1", "q", "%", "+", " "})
    void inputCharacter(String userInput) {
        assertThatThrownBy(() -> userInputValidation.checkIsNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000단위 인지 확인")
    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(ints = {1, 20, 1001})
    void inputBuyLotto(int amount) {
        assertThatThrownBy(() -> userInputValidation.checkBuyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 6개인지 확인(구분자는 쉼표)")
    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    void inputCorrectCount(String userInput) {
        assertThatThrownBy(() -> userInputValidation.checkCorrectCount(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("1~45 사이의 수인지 확인")
    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(ints = {0, -1, 46, 47})
    void inputValidNumber(int number) {
        assertThatThrownBy(() -> userInputValidation.checkInvalidNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 확인(해당 메소드 값을 주기 전 replaceAll 함)")
    @ParameterizedTest(name = "[{index}] : {0} : IllegalArgumentException 발생")
    @ValueSource(strings = {"", " ", "\t", "\n"})
    void inputWithWhiteSpace(String userInput) {
        String finalUserInput = userInput.replaceAll("\\s", "");
        assertThatThrownBy(() -> userInputValidation.checkWhiteSpace(finalUserInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}