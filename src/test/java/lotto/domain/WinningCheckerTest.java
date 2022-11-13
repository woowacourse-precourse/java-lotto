package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class WinningCheckerTest {
    @Test
    @DisplayName("당첨 여부를 정확히 판단하는 지 테스트")
    void check_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningOne = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningTwo = new ArrayList<>(List.of(1, 2, 3, 4, 5, 10));
        List<Integer> winningThree = new ArrayList<>(List.of(1, 2, 3, 4, 5, 13));
        List<Integer> winningFour = new ArrayList<>(List.of(1, 2, 3, 4, 7, 13));
        List<Integer> winningFive = new ArrayList<>(List.of(1, 2, 3, 7, 9, 13));
        List<Integer> winningNone = new ArrayList<>(List.of(1, 2, 7, 8, 9, 10));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningOne))
                .isEqualTo(1);
        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningTwo))
                .isEqualTo(2);
        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningThree))
                .isEqualTo(3);
        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningFour))
                .isEqualTo(4);
        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningFive))
                .isEqualTo(5);
        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningNone))
                .isEqualTo(0);
    }
}
