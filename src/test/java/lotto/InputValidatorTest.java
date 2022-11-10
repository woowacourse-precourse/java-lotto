package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;



class InputValidatorTest {
    @DisplayName("입력한 당첨번호에 ','와 숫자가 아닌 문자가 존재하면 예외를 던진다.")
    @Test
    void inputNumbersByInvalidSeparator() {
        String input = "1, 3, 2, 5, 4- 5";

        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
       }

    @DisplayName("사용자가 올바르지 않은 money를 넣을 시 예외를 던진다")
    @Test
    void inputMoneyByInvalidForm() {
        String input = "1,000";

        assertThatThrownBy(() -> new User(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
