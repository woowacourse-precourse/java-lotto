package lotto;

import lotto.domain.Raffle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaffleTest {

    @DisplayName("당첨 번호는 쉼표 기준으로 구분한다")
    @Test
    void setWinningNumberTest() {
        String input = "1,2,3,4,5,6";

        assertThat(new Raffle().setWinningNumber(input)).contains(1,2,3,4,5,6);
    }

    @DisplayName("당첨 번호와 로또 번호를 비교한다")
    @Test
    void compareNumbersTest() {
        List<Integer> lottoNumber = List.of(6,12,24,26,32,43);
        List<Integer> winningNumber = List.of(2,6,10,12,25,32);
        int result = 3;
        assertThat(new Raffle().compareNumbers(lottoNumber, winningNumber)).isEqualTo(result);
    }
}
