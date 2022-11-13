package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import lotto.controller.InputController;
import lotto.domain.Money;
import lotto.utils.ExceptionType;
import lotto.view.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class InputTest {
    private MockedStatic<Input> input;
    @BeforeEach
    void before() {
        input = mockStatic(Input.class);
    }

    @AfterEach
    void after() {
        input.close();
    }

    @DisplayName("정확한 금액을 입력받는 경우 Money 객체가 return된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "80000"})
    void inputMoney(String target) {
        when(Input.readLine()).thenReturn(target);

        InputController inputController = new InputController();
        Money money = inputController.getMoney();

        assertThat(money.getMoney()).isEqualTo(Integer.parseInt(target));
    }

    @DisplayName("숫자가 아닌 것을 입력받는 경우 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"!1102", "err0r", "string"})
    void inputMoneyByNotNumber(String target) {
        when(Input.readLine()).thenReturn(target);

        InputController inputController = new InputController();

        assertThatThrownBy(inputController::getMoney).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_NOT_NUMBER.getMessage());
    }
}
