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
}
