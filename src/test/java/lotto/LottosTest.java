package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("로또 리스트 생성 테스트")
    @Test
    void createLottos() {
        int testTicketAmount = 3;
        Lottos testLottos = new Lottos(testTicketAmount);
        for (Lotto testLotto : testLottos.lottos) {
            testLotto.printLotto();
        }
    }
}