package lotto.UI;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputMoneyTest {
    @ParameterizedTest(name = "구입금액=={0}일 때")
    @ValueSource(strings = {"english", "한글", "--", " "})
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    void inputMoneyByNonNumericCharacter(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputMoney().input())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000원 보다 적으면 예외가 발생한다.")
    void inputMoneyByUnder1000() {
        InputStream in = new ByteArrayInputStream("900".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputMoney().input())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000의 배수가 아니면 예외가 발생한다.")
    void inputMoneyByNonMultipleOf1000() {
        InputStream in = new ByteArrayInputStream("1100".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputMoney().input())
                .isInstanceOf(IllegalArgumentException.class);
    }
}