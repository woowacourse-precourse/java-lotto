package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("예외 테스트: 당첨 번호로 빈 문자열이 들어올 경우")
    @Test
    void winningNumberNullTest() {
        String input = "";

        assertThatThrownBy(() -> new WinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 당첨 번호로 숫자가 아닌 값이 들어올 경우")
    @Test
    void winningNumberNumericTest() {
        String input = "1,e,3,4,5,6";

        assertThatThrownBy(() -> new WinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("예외 테스트: 당첨 번호 구분자로 ,가 아닌 다른 문자가 올 경우")
    @Test
    void winningNumberSeparatorTest() {
        String input = "1 2 3 4 5 6";

        assertThatThrownBy(() -> new WinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
