package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("1234567890,이 아닌 다른 문자가 섞여 들어옴.")
    @Test
    void createOtherInput() {
        WinningNumber winningNumber = new WinningNumber();
        assertThatThrownBy(() -> winningNumber.getNumbers("1,2,3w4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스가 1234567890,이 아닌 다른 문자가 섞여 들어옴.")
    @Test
    void createOtherInput_bonus() {
        Utils util = new Utils();
        assertThatThrownBy(() -> util.isNumeric("w2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 + 로또가 유효함.")
    @Test
    void createOtherInzput_bonus() {
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.lotto = new Lotto(List.of(1,2,3,4,5,6));
        winningNumber.bonus = 5;
        assertThatThrownBy(() -> winningNumber.getWinningNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
