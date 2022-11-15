package lotto;

import domain.Lotto;
import domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("당첨 번호(보너스 x) 중복 케이스")
    @Test
    void winningNumberDuplicate() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,3,4,5", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningNumber("4,10,12,10,13,16", 43))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 중복 케이스")
    @Test
    void bonusNumberDuplicate() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
