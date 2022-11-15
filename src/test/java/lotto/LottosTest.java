package lotto;

import lotto.model.Lotto;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {
    @DisplayName("로또 리스트 생성 테스트")
    @Test
    void createLottos() {
        int ticketAmount = 3;
        Lottos testLottos = new Lottos(ticketAmount);
        for (Lotto testLotto : testLottos.lottos) {
            testLotto.printLotto();
        }
    }
}