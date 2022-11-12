package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumberTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createWinNumberByOverSize() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
    @Test
    void createWinNumberByCharacter() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
    @Test
    void createWinNumberByDuplicate() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 포함되면 예외가 발생한다.")
    @Test
    void createWinNumberWithInvalidNumber() {
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinNumber("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
