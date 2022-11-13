package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ExceptionType;
import lotto.view.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class InputTest {
    private MockedStatic<Console> console;
    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("정확한 숫자를 입력한 경우 해당 숫자가 return된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "80000"})
    void readNumber(String target) {
        when(Console.readLine()).thenReturn(target);

        assertThat(Input.readNumber()).isEqualTo(Integer.parseInt(target));
    }

    @DisplayName("숫자가 아닌 것을 입력받는 경우 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"!1102", "err0r", "string"})
    void readNumberByNotNumber(String target) {
        when(Console.readLine()).thenReturn(target);

        assertThatThrownBy(Input::readNumber).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_NOT_NUMBER.getMessage());
    }

    @DisplayName("정확한 문자열을 입력한 경우 해당 문자열이 return된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "3000", "string"})
    void readLine(String target) {
        when(Console.readLine()).thenReturn(target);

        assertThat(Input.readLine()).isEqualTo(target);
    }
}
