package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("1~45 범위 외의 숫자일 경우 예외 발생")
    @Test
    void createWinningByIncorrectRangeNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(0,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 번호일 경우 예외 발생")
    @Test
    void createWinningByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("숫자 외 형식이 들어올 경우 예외 발생")
    @Test
    void createWinningByWrongFormatNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,a,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 번호로 이뤄지지 않을 경우 예외 발생")
    @Test
    void createWinningByOverSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}
