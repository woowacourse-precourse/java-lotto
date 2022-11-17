package lotto.domain.lottomachine.winningnumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberSystemTest {
    private WinningNumberSystem winningNumberSystem;

    @BeforeEach
    void setUp() {
        winningNumberSystem = WinningNumberSystem.getInstance();
    }

    @DisplayName("receiveWinningNumber 메소드에서 사용자 입력 숫자에 중복이 있을 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,5", "4,34,12,33,21,4"})
    void createWinningNumbers_duplication_error_test(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> winningNumberSystem.createWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호는 중복될 수 없습니다.");
    }

    @DisplayName("createWinningNumbers 메소드에서 사용자 입력이 검증을 통과할 때 WinningNumbers를 반환하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1,2,3,4,5,45", "4,34,12,33,21,44"})
    void createWinningNumbers_test(String input) {
        WinningNumbers winningNumbers = winningNumberSystem.createWinningNumbers(input);

        assertThat(winningNumbers).isInstanceOf(WinningNumbers.class);
    }

    @DisplayName("validateDuplication 메소드에서 숫자와 WinningNumbers가 중복될 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 5})
    void validateDuplication_test(int number) throws NoSuchMethodException, IllegalAccessException {
        List<WinningNumber> numbers = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(WinningNumber::from)
                .collect(Collectors.toList());
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);
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
    void receiveBonusNumber_test(String input) {
        List<WinningNumber> numbers = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(WinningNumber::from)
                .collect(Collectors.toList());
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);

        assertThat(winningNumberSystem.creativeBonusNumber(input, winningNumbers)).isInstanceOf(WinningNumber.class);
    }

    @DisplayName("receiveBonusNumber 메소드에서 사용자 입력 숫자와 WinningNumbers가 중복될 때 오류가 발생하는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1", "2", "5"})
    void receiveBonusNumber_error_test(String input) {
        List<WinningNumber> numbers = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(WinningNumber::from)
                .collect(Collectors.toList());
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);

        assertThatThrownBy(() -> winningNumberSystem.creativeBonusNumber(input, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
    }
}