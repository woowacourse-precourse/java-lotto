package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningMoneyTest {
    List<Integer> rank = List.of(1,2,3,4,5);
    WinningMoney winningMoney = new WinningMoney(rank);

    @DisplayName("각 등수 개수 비교")
    @Test
    void createRankCount() {
        List<Integer> rankCount = List.of(1,1,1,1,1);
        assertThat(winningMoney.getRANKCOUNT()).isEqualTo(rankCount);
    }

    @DisplayName("당첨금 비교")
    @Test
    void createWinningMoney() {
        int winningMoneyTest = 2000000000 + 30000000 + 1500000 + 50000 + 5000;
        assertThat(winningMoney.getMONEY()).isEqualTo(winningMoneyTest);
    }
}
