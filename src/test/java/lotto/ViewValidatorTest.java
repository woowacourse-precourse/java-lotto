package lotto;

import lotto.view.ViewValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ViewValidatorTest {
    @DisplayName("숫자가 아닌 다른 글자가 들어가면 예외가 발생한다")
    @Test
    void createMoneyByNotNumber() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateNumberType("a1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 들어가면 예외가 발생하지 않는다")
    @Test
    void createMoneyByNumber() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateNumberType("1000"));
    }

    @DisplayName("숫자 예외가 발생 시 메시지에 접두어로 [ERROR]가 들어간다")
    @Test
    void errorMessageByNotNumber() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateNumberType("a1000"))
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("1000원 단위가 아닌 돈이 입력됐을 때 예외가 발생한다")
    @Test
    void createMoneyByNotUnitOf1000() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateUnitOf1000("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위인 돈이 입력됐을 때 예외가 발생하지 않는다")
    @Test
    void createMoneyByUnitOf1000() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateUnitOf1000("2000"));
    }

    @DisplayName("값이 숫자가 아니면 예외가 발생한다")
    @Test
    void createNumberByNotIntegerType() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateNumberType("a1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 숫자면 예외가 발생하지 않는다")
    @Test
    void createNumberByIntegerType() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateNumberType("11"));
    }

    @DisplayName("빈 문자열이 들어가면 예외가 발생한다")
    @Test
    void createNumberByEmptyString() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateEmptyString(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열이 들어가지 않으면 예외가 발생하지 않는다")
    @Test
    void createNumberByFilledString() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateEmptyString("1234"));
    }
}
