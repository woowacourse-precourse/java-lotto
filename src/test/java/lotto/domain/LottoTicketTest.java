package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket lottoTicket = new LottoTicket();
    @DisplayName("구매한 로또 번호가 생성된다.")
    @Test
    void createLottoTicket() {
        List<Integer> random = List.of(1,3,6,7,8,9);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoTicket.makeLotto()).isEqualTo(random);
                },
                List.of(1, 3, 6, 7, 8, 9)
        );
    }

    @DisplayName("구매한 로또 번호를 오름차순으로 출력한다.")
    @Test
    void createAndPrintLottoTicket() {
        List<Integer> random = List.of(1, 7, 8, 9, 15, 42);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThat(lottoTicket.makeLotto()).isEqualTo(random);
                },
                List.of(42, 8, 1, 7, 15, 9)
        );
    }
}
