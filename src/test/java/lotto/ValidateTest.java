package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ValidateTest {

    @Test
    void validMoney() {
    }

    @Test
    void validUserInputMoney() {
    }

    @Test
    void validateUserInput() {
        String testcase = "1,2,3,45, ";
        Validate validate = new Validate();
        assertThatThrownBy(() -> validate.validateUserInput(testcase))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validateBonusNumber() {
        String testcase = "1";
        List<Integer> testcase1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Validate test = new Validate();
        assertThatThrownBy(() -> test.validateBonusNumber(testcase1, testcase))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validUserWinningNumber() {
        Validate test = new Validate();
        List<Integer> testcase1 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 48));
        List<Integer> testcase2 = new ArrayList<>(List.of(1, 2, 3, 5, 5, 6));
        assertThatThrownBy(() -> test.validUserWinningNumber(testcase1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1 ~ 45 사이의 숫자를 입력하세요.");
        assertThatThrownBy(() -> test.validUserWinningNumber(testcase2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자가 있습니다.");
    }
}