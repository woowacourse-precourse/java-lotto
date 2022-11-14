package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class WinningCheckerTest {

    @Test
    @DisplayName("1등 당첨의 경우 정확하게 이를 판정하는 가?")
    void check_winning_one_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningOne = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningOne))
                .isEqualTo("WINNING_ONE");
    }

    @Test
    @DisplayName("2등 당첨의 경우 정확하게 이를 판정하는 가?")
    void check_winning_two_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningTwo = new ArrayList<>(List.of(1, 2, 3, 4, 5, 10));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningTwo))
                .isEqualTo("WINNING_TWO");
    }

    @Test
    @DisplayName("3등 당첨의 경우 정확하게 이를 판정하는 가?")
    void check_winning_three_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningThree = new ArrayList<>(List.of(1, 2, 3, 4, 5, 13));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningThree))
                .isEqualTo("WINNING_THREE");
    }

    @Test
    @DisplayName("4등 당첨의 경우 정확하게 이를 판정하는 가?")
    void check_winning_four_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningFour = new ArrayList<>(List.of(1, 2, 3, 4, 7, 13));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningFour))
                .isEqualTo("WINNING_FOUR");
    }

    @Test
    @DisplayName("5등 당첨의 경우 정확하게 이를 판정하는 가?")
    void check_winning_five_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningFive = new ArrayList<>(List.of(1, 2, 3, 7, 9, 13));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningFive))
                .isEqualTo("WINNING_FIVE");
    }

    @Test
    @DisplayName("당첨되지 않은 경우 정확하게 이를 판정하는 가?")
    void check_winning_none_test() {
        List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4 ,5, 6));
        int bonusNumber = 10;
        List<Integer> winningNone = new ArrayList<>(List.of(1, 2, 7, 8, 9, 10));

        assertThat(WinningChecker.check(winningNumber, bonusNumber, winningNone))
                .isEqualTo("null");
    }
}
