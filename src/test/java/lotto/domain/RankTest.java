package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RankTest {

    @DisplayName("3개이상 맞은 count 가 winningRanks 의 값의 합과 같아야한다.")
    @Test
    void countWinningRanksTest() {
        Amount amount = new Amount(100000);//구입 금액 4000입력
        LottoGenerator lottoGenerator = new LottoGenerator(amount.getPurchasesQuantity());
        Rank rank = new Rank(Arrays.asList(1, 2, 3, 4, 5, 6)); // 당첨 번호 1,2,3,4,5,6 입력
        rank.countWinningRanks(lottoGenerator.getUserLottoTickets(), 7); //보너스 번호 7입력

        int count = 0;
        for (List<Integer> lottoTicket : lottoGenerator.getUserLottoTickets()) {
            if (lottoTicket.size() < 4 ) {
                count++;
            }
        }

        int result = rank.winningRanks.values().stream().mapToInt(Integer::intValue).sum();

        Assertions.assertThat(result).isEqualTo(count);
    }
}
