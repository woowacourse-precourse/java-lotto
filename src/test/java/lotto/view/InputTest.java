package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {

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

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,49"})
    @DisplayName("입력받은 당첨 번호가 범위에 맞는가?")
    void vaildNumsRange(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> Input.askWinLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NOT_VAILDRANGE);
    }

    @DisplayName("입력받은 당첨 번호가 6개 숫자배열이 맞는가?")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,6,9,10,45"})
    void isSize6(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> Input.askWinLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NOT_SIZE6);
    }

    @DisplayName("입력받은 당첨 번호가 중복되지는 않았는가?")
    @ParameterizedTest
    @ValueSource(strings = {"9,1,2,3,6,9"})
    void isDiffrentTest(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> Input.askWinLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NOT_DIFFRENT);
    }

    @DisplayName("입력받은 당첨 번호가 모두 숫자인가?")
    @ParameterizedTest
    @ValueSource(strings = {"9,1,2,3,a,10"})
    void isInts(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> Input.askWinLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_NOT_NUMBER);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}