package lotto;

import lotto.domain.Raffle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaffleTest {

    @DisplayName("당첨 번호는 쉼표 기준으로 구분한다")
    @Test
    void setWinningNumberTest() {
        String input = "1,2,3,4,5,6";

        assertThat(new Raffle().setWinningNumber(input)).contains(1,2,3,4,5,6);
    }
}
