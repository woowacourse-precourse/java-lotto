package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerSelectorTest {
    @Test
    public void comparisonLogicTest() {
        WinnerSelector winnerSelector = new WinnerSelector("test");;
        List<Integer> winningNumber = winnerSelector.getWinningNumber();
        Integer bonusNumber = winnerSelector.getBonusNumber();

        System.out.println(winningNumber);
        System.out.println(bonusNumber);

        List<Integer> matchCount = winnerSelector.compareLotto(new Lotto(List.of(1, 2, 3, 4, 44, 9)));
        assertThat(matchCount).isEqualTo(List.of(4, 1));



    }


}
