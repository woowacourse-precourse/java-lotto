package lotto;

import lotto.domain.Roulette;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RouletteTest {
    @DisplayName("당첨 번호와 로또 번호를 비교한다")
    @Test
    void compareNumbersTest() {
        List<Integer> lottoNumber = List.of(6, 12, 24, 26, 32, 43);
        List<Integer> winningNumber = List.of(2, 6, 10, 12, 25, 32);
        int result = 3;
        assertThat(new Roulette().compareNumbers(lottoNumber, winningNumber)).isEqualTo(result);
    }
}
