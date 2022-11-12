package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static lotto.Application.checkWinningNumberByIndex;
import static org.assertj.core.api.Assertions.assertThat;

class CheckWinningNumberByIndexMethodTest {
    @Test
    void checkWinningNumberByIndex_메소드_예외_테스트1() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        boolean[] isWinningNumber = checkWinningNumberByIndex(winningNumbers);
        for(int number = 7; number <= 45; number++)
            assertThat(isWinningNumber[number]).isEqualTo(false);
    }

    @Test
    void checkWinningNumberByIndex_메소드_정상_입력_테스트1() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(3, 7, 10, 15, 1, 45));
        boolean[] isWinningNumber = checkWinningNumberByIndex(winningNumbers);
        for(int number : winningNumbers)
            assertThat(isWinningNumber[number]).isEqualTo(true);
    }
}