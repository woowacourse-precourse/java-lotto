package lotto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import constant.Message;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCheckerTest {
    private static WinningNumber winningNumber;

    @BeforeAll
    static void initWinningInfo() {
        winningNumber = new WinningNumber();

        String winningNumberInput = "1,2,3,4,5,6";

        InputStream in1 = new ByteArrayInputStream(winningNumberInput.getBytes());
        System.setIn(in1);

        winningNumber.createWinningNumbers();

        String bonusNumberInput = "7";

        InputStream in2 = new ByteArrayInputStream(bonusNumberInput.getBytes());
        System.setIn(in2);

        winningNumber.createBonusNumber();
    }

    @DisplayName("1등 당첨인 경우 1등 당첨 내역이 1번이어야 한다.")
    @Test
    void winRankFirst() {
        WinningChecker winningChecker = new WinningChecker(winningNumber);
        winningChecker.setWinningChart(List.of(1, 2, 3, 4, 5, 6));

        assertThat(winningChecker.getWinningChart().get(Message.RANKFIRST)).isEqualTo(1);
    }

    @DisplayName("2등 당첨인 경우 2등 당첨 내역이 1번이어야 한다.")
    @Test
    void winRankSecond() {
        WinningChecker winningChecker = new WinningChecker(winningNumber);
        winningChecker.setWinningChart(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winningChecker.getWinningChart().get(Message.RANKSECOND)).isEqualTo(1);
    }

    @DisplayName("3등 당첨인 경우 3등 당첨 내역이 1번이어야 한다.")
    @Test
    void winRankThird() {
        WinningChecker winningChecker = new WinningChecker(winningNumber);
        winningChecker.setWinningChart(List.of(1, 2, 3, 4, 5, 45));

        assertThat(winningChecker.getWinningChart().get(Message.RANKTHIRD)).isEqualTo(1);
    }

    @DisplayName("4등 당첨인 경우 4등 당첨 내역이 1번이어야 한다.")
    @Test
    void winRankFourth() {
        WinningChecker winningChecker = new WinningChecker(winningNumber);
        winningChecker.setWinningChart(List.of(1, 2, 3, 4, 44, 45));

        assertThat(winningChecker.getWinningChart().get(Message.RANKFOURTH)).isEqualTo(1);
    }

    @DisplayName("5등 당첨인 경우 5등 당첨 내역이 1번이어야 한다.")
    @Test
    void winRankFifth() {
        WinningChecker winningChecker = new WinningChecker(winningNumber);
        winningChecker.setWinningChart(List.of(1, 2, 3, 43, 44, 45));

        assertThat(winningChecker.getWinningChart().get(Message.RANKFIFTH)).isEqualTo(1);
    }

    @DisplayName("4등 당첨 두 번, 5등 당첨 두 번인 경우 해당 당첨 내역이 2번씩이어야 한다.")
    @Test
    void winSeveralTimes() {
        WinningChecker winningChecker = new WinningChecker(winningNumber);
        winningChecker.setWinningChart(List.of(1, 2, 3, 43, 44, 45));
        winningChecker.setWinningChart(List.of(3, 2, 1, 43, 44, 45));
        winningChecker.setWinningChart(List.of(1, 2, 3, 4, 44, 45));
        winningChecker.setWinningChart(List.of(4, 3, 2, 1, 44, 45));

        assertThat(winningChecker.getWinningChart().get(Message.RANKFOURTH)).isEqualTo(2);
        assertThat(winningChecker.getWinningChart().get(Message.RANKFIFTH)).isEqualTo(2);
    }
}
