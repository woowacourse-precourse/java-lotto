package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.Model.Buyer;
import lotto.Model.Comparison;
import lotto.Model.WinningTicket;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;

public class ComparisonTest {

    private Buyer buyer;
    private WinningTicket ticket;
    private Comparison comparison = new Comparison();

    @Test
    void 결과값_테스트() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                buyer = new Buyer("8000");
            },
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45)
        );
        ticket = new WinningTicket("1,2,3,4,5,6");
        ticket.saveBonus("7");
        comparison.compareLotto(buyer.getLottoNumber(), ticket);
        assertThat(comparison.getSavedResult()
            .putIfAbsent("3",1))
            .isEqualTo(1);
    }
}
