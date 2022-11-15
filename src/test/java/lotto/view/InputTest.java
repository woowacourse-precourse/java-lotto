package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {

    static Scanner scanner;

    @BeforeEach
    void init() {
        scanner = new Scanner(System.in);
    }

    @Test
    void inputMoney() {
        int input = 9000;
        assertThat(Input.inputMoney(input)).isEqualTo(9);
    }

    @Test
    @DisplayName("입력이 0인 경우 테스트")
    void isZeroTest() {
        int input = 0;
        assertThatThrownBy(() -> {
            Input.inputMoney(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NULL);
    }

    @Test
    @DisplayName("입력이 1000으로 안나눠지는 경우 테스트")
    void isOtherNumTest() {
        int input = 900;
        assertThatThrownBy(() -> {
            Input.inputMoney(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NOT_DIVDE1000);
    }

    @DisplayName("입력받은 당첨 번호가 범위에 맞는가?")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,49"})
    void vaildNumsRange(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        scanner = new Scanner(System.in);
        assertThatThrownBy(() -> Input.askWinNums())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NOT_VAILDRANGE);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}