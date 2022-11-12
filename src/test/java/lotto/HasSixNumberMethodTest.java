package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.hasSixNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HasSixNumberMethodTest {
    @Test
    void hasSixNumbers_메소드_예외_테스트1() {
        String winningNumberInput = "1,2,3,4,5,6,7";
        String[] splitNumbers = winningNumberInput.split(",");
        assertThatThrownBy(() -> hasSixNumbers(splitNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 쉼표로 구분되는 6개의 수로 구성돼야 합니다.");
    }

    @Test
    void hasSixNumbers_메소드_예외_테스트2() {
        String winningNumberInput = "1,2,3,4,5";
        String[] splitNumbers = winningNumberInput.split(",");
        assertThatThrownBy(() -> hasSixNumbers(splitNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 쉼표로 구분되는 6개의 수로 구성돼야 합니다.");
    }

    @Test
    void hasSixNumbers_메소드_예외_테스트3() {
        String winningNumberInput = "1,04,72,30,89,01,57";
        String[] splitNumbers = winningNumberInput.split(",");
        assertThatThrownBy(() -> hasSixNumbers(splitNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 쉼표로 구분되는 6개의 수로 구성돼야 합니다.");
    }

    @Test
    void hasSixNumbers_메소드_정상_입력_테스트1() {
        String winningNumberInput = "1654,04021,7248765,30213,89654,123051";
        String[] splitNumbers = winningNumberInput.split(",");
        hasSixNumbers(splitNumbers);
    }

    @Test
    void hasSixNumbers_메소드_정상_입력_테스트2() {
        String winningNumberInput = "0123456789,00000,7248765,30213,89654,11516548";
        String[] splitNumbers = winningNumberInput.split(",");
        hasSixNumbers(splitNumbers);
    }
}