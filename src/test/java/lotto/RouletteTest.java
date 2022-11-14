package lotto;

import lotto.domain.Roulette;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RouletteTest {
    @DisplayName("당첨 번호와 로또 번호를 비교하여 개수 카운트")
    @Test
    void compareWithWinningNumber() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> myLotto = List.of(1, 2, 3, 7, 8, 9);
        int result = 3;
        Roulette roulette = new Roulette(winningNumber, 10);
        assertThat(roulette.compareWithWinningNumber(myLotto)).isEqualTo(result);
    }
}
