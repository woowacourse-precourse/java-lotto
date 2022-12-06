package lotto;

import lotto.outputview.OutputLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {
    Lottos lottos = new Lottos();
    OutputLottos outputLottos = new OutputLottos();

    @Test
    @DisplayName("로또 구입 후 로또 리스트 출력")
    void 로또_출력() {
        int amount = 8;
        lottos.issuedLottos(amount);
        List<Lotto> lottoList = lottos.getLottos();
        outputLottos.printMsg(amount);
        for (int i = 0; i < amount; i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
    }
}