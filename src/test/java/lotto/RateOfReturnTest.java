package lotto;

import lotto.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RateOfReturnTest {
    @DisplayName("총 수익률을 계산한다.")
    @Test
    public void calculateRateOfReturn() {
        Ticket ticket = new Ticket(1, Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 12, 13, 14))));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int money = 1000;
        double percentage = Rank.FIFTH.getWinnings() / (double) money * 100;
        double rate = Math.round(percentage * 10.0) / 10.0;
        Win win = Win.compare(ticket, winningNumbers, bonusNumber);
        RateOfReturn rateOfReturn = new RateOfReturn(win, money);

        assertThat(rateOfReturn.calculate()).isEqualTo(rate);
    }
}