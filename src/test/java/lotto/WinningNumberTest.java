package lotto;

import lotto.Domain.WinningNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;


public class WinningNumberTest {

    @DisplayName("[정상] 당첨 번호가 올바른 경우")
    @Test
    void createWinningNums() {
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNums);
    }

    @DisplayName("당첨 번호 개수가 6개가 아니면 예외가 발생")
    @Test
    void createWinningNums_Ex1() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있는 경우 예외가 발생")
    @Test
    void createWinningNums_Ex2() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 3, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
