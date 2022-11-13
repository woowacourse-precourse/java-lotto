package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}