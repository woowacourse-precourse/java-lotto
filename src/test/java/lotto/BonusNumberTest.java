package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberTest {
    static Lotto lotto;

    @BeforeAll
    static void initLotto() {
        lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("보너스 숫자 Lotto 외의 값은 문제 없이 생성된다")
    @ValueSource(strings = {"7", "14", "21", "35", "42", "45"})
    @ParameterizedTest
    void checkBonusNumberRight(String input) {
        assertDoesNotThrow(() -> lotto.getLottoBonusNumber(input));
    }

    @DisplayName("보너스 숫자를 숫자외의 값으로 입력했을 경우 예외가 발생한다")
    @ValueSource(strings = {"a", "-", "/", "*", ".", ","})
    @ParameterizedTest
    void checkBonusNumberInput(String input) {
        assertThatThrownBy(() -> lotto.validateBonusNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자를 1~45 사이의 숫자가 아니라면 예외가 발생한다")
    @ValueSource(strings = {"0", "46", "48", "100"})
    @ParameterizedTest
    void checkBonusNumberRange(String input) {
        assertThatThrownBy(() -> lotto.validateBonusNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 lotto값과 중복된 숫자라면 예외가 발생한다")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    @ParameterizedTest
    void checkBonusNumberDup(String input) {
        assertThatThrownBy(() -> lotto.validateBonusNumberDup(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}