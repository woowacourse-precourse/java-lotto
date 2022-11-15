package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewValidatorValidatorTest {
    private InputViewValidator inputViewValidator;

    @BeforeEach
    void setUp() {
        this.inputViewValidator = new InputViewValidator();
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 경우 에러를 반환한다.")
    @Test
    void inputPurchaseMoneyNotDivideThousand() {
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> inputViewValidator.validateDivideThousand(2000)),
                () -> assertThatThrownBy(() -> inputViewValidator.validateDivideThousand(1300))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputViewValidator.validateDivideThousand(100))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputViewValidator.validateDivideThousand(0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자 이외의 값을 입력하면 에러를 반환한다.")
    @Test
    void inputNotNumber() {
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> inputViewValidator.validateNumber("123")),
                () -> assertThatThrownBy(() -> inputViewValidator.validateNumber("abc"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputViewValidator.validateNumber("!#@"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> inputViewValidator.validateNumber("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("쉼표로 구분한 문자가 숫자 이외의 값이면 에러를 반환한다..")
    @Test
    void notContainRest() {
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> inputViewValidator.validateContainRest("1,2,3,4,6")),
                () -> assertThatThrownBy(() -> inputViewValidator.validateContainRest("12 34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest(name = "쉼표로 구분한 문자가 숫자 이외의 값이면 에러를 반환한다..")
    @ValueSource(strings = {"a,b,c", "1,2,a", "1, ", ",", " ,", "1,2,!"})
    void inputSplitCommaNotNumber(String text) {
        assertThatThrownBy(() -> inputViewValidator.validateSplitByRestNumber(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
