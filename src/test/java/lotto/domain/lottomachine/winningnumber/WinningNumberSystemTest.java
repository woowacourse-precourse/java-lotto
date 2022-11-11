package lotto.domain.lottomachine.winningnumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static lotto.domain.lottomachine.winningnumber.WinningNumberSystem.REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberSystemTest {
    private WinningNumberSystem winningNumberSystem;

    @BeforeEach
    void setUp() {
        winningNumberSystem = new WinningNumberSystem();
    }

    @DisplayName("validateUserInput 메소드에 서로 맞지 않는 문자열과 정규식이 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1.2,3,4,5,6", "1,2,3,4,5,r", "1,2,3", "1"})
    void validateForm_error_test(String number) throws NoSuchMethodException, IllegalAccessException {
        Method method = winningNumberSystem.getClass().getDeclaredMethod("validateUserInput", String.class, String.class);
        method.setAccessible(true);

        try {
            method.invoke(winningNumberSystem, number, REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 여섯 개의 숫자를 \",\"로 구분해서 입력해야 합니다.");
        }
    }

    @DisplayName("readUserInput 메소드가 사용자 입력과 정규식이 일치할 때 사용자 입력값을 반환하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,6", "4,34,12,33,21,44"})
    void readUserInput_test(String input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Method method = winningNumberSystem.getClass().getDeclaredMethod("readUserInput", String.class);
        method.setAccessible(true);

        String userInput = (String) method.invoke(winningNumberSystem, REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT);

        assertThat(userInput).isEqualTo(input);
    }

    @DisplayName("readUserInput 메소드가 사용자 입력과 정규식이 일치하지 않을 때 오류를 발생시키는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1.2,3,4,5,6", "1,2,3,4,5,r", "1,2,3", "1,444,222,1111,22,11"})
    void readUserInput_error_test(String input) throws NoSuchMethodException, IllegalAccessException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Method method = winningNumberSystem.getClass().getDeclaredMethod("readUserInput", String.class);
        method.setAccessible(true);

        try {
            String userInput = (String) method.invoke(winningNumberSystem, REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 여섯 개의 숫자를 \",\"로 구분해서 입력해야 합니다.");
        }
    }
}