package lotto;

import lotto.model.*;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultTest {
    @DisplayName("당첨금 계산 확인.")
    @Test
    void createLotto() {

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoTicket lottoTicket = new LottoTicket(7);
                    Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
                    LuckyNumbers luckyNumbers = new LuckyNumbers(lotto,7);
                    Result result = lottoTicket.calculateStatistic(luckyNumbers);
                    assertThat(result.calculatePrize()).isEqualTo(50000);

                },
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 3, 10, 14, 22, 45)
        );

    }
    @DisplayName("수익률 계산 확인.")
    @Test
    void createLotto2() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoCount amount = new LottoCount(7000);
                    LottoTicket lottoTicket = new LottoTicket(7);
                    Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
                    LuckyNumbers luckyNumbers = new LuckyNumbers(lotto,7);
                    Result result = lottoTicket.calculateStatistic(luckyNumbers);
                    assertThat(result.calculateProfit(amount)).isEqualTo((float)714.2857);

                },
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 3, 4, 9, 10),
                List.of(1, 3, 10, 14, 22, 45)
        );
    }
}
