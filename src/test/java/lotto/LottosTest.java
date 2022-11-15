package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lottos;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("발행한 로또 티켓 수량 구하기")
    @Test
    void createLottoTicketCount() {
        assertSimpleTest(() -> {
            Lottos lottos = new Lottos(10);
            assertThat(lottos.getLottos().size()).isEqualTo(10);
        });
    }

}
