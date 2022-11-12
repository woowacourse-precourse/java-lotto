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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.lottomachine.winningnumber.WinningNumberSystem.REGULAR_EXPRESSION_FOR_WINNING_NUMBERS_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
                    .hasMessageContaining("[ERROR] 숫자 입력 형식이 맞지 않습니다.");
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
                    .hasMessageContaining("[ERROR] 숫자 입력 형식이 맞지 않습니다.");
        }
    }

    @DisplayName("createWinningNumberList 메소드에 1~45범위 안의 숫자 문자열이 입력되었을 때 WinningNumber 리스트를 반환하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,45", "4,34,12,33,21,44"})
    void createWinningNumberList_test(String input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = winningNumberSystem.getClass().getDeclaredMethod("createWinningNumberList", String.class);
        method.setAccessible(true);

        assertThat(method.invoke(winningNumberSystem, input)).isInstanceOf(List.class);
    }

    @DisplayName("createWinningNumberList 메소드에 1~45범위 밖의 숫자 문자열이 입력되었을 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,46", "4,34,12,33,21,0"})
    void createWinningNumberList_error_test(String input) throws NoSuchMethodException, IllegalAccessException {
        Method method = winningNumberSystem.getClass().getDeclaredMethod("createWinningNumberList", String.class);
        method.setAccessible(true);

        try {
            method.invoke(winningNumberSystem, input);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자는 1부터 45에 속해야 합니다.");
        }
    }

    @DisplayName("receiveWinningNumber 메소드에서 사용자 입력 숫자에 중복이 있을 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,5", "4,34,12,33,21,4"})
    void receiveWinningNumber_duplication_error_test(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> winningNumberSystem.receiveWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호는 중복될 수 없습니다.");
    }

    @DisplayName("receiveWinningNumber 메소드에서 사용자 입력이 검증을 통과할 때 WinningNumbers를 반환하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,45", "4,34,12,33,21,44"})
    void receiveWinningNumber_test(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        WinningNumbers winningNumbers = winningNumberSystem.receiveWinningNumber();

        assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("validateDuplication 메소드에서 숫자와 WinningNumbers가 중복될 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 5})
    void validateDuplication_test(int number) throws NoSuchMethodException, IllegalAccessException {
        List<WinningNumber> numbers = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(WinningNumber::new)
                .collect(Collectors.toList());
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        Method method = winningNumberSystem.getClass().getDeclaredMethod("validateDuplication", int.class, WinningNumbers.class);
        method.setAccessible(true);

        try {
            method.invoke(winningNumberSystem, number, winningNumbers);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    @DisplayName("receiveBonusNumber 메소드에서 사용자 입력 숫자와 WinningNumbers가 중복되지 않을 때 WinningNumber를 반환하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"11", "22", "35"})
    void receiveBonusNumber_test(String input) throws NoSuchMethodException, IllegalAccessException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<WinningNumber> numbers =Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(WinningNumber::new)
                .collect(Collectors.toList());
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        assertThat(winningNumberSystem.receiveBonusNumber(winningNumbers)).isInstanceOf(WinningNumber.class);
    }

    @DisplayName("receiveBonusNumber 메소드에서 사용자 입력 숫자와 WinningNumbers가 중복될 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1", "2", "5"})
    void receiveBonusNumber_error_test(String input) throws NoSuchMethodException, IllegalAccessException {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<WinningNumber> numbers =Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(WinningNumber::new)
                .collect(Collectors.toList());
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        assertThatThrownBy(() -> winningNumberSystem.receiveBonusNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
    }
}