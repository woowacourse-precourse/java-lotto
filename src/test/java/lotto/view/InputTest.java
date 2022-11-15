package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {
    @DisplayName("구입금액 입력 값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void inputPurchaseAmount() {
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Input::inputPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 된 당첨 번호의 구분자가 콤마가 아닐 경우 예외가 발생한다.")
    @Test
    void validateComma() {
        String input = "1#2#3#4#5#6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Input::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 된 당첨 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void validate() {
        String input = "a,b,c,d,e,f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(Input::inputWinningNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }
}