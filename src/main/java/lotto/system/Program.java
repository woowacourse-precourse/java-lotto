package lotto.system;

import lotto.generation.Lotto;
import lotto.generation.LottoGenerator;

import java.util.List;

public class Program {

    private LottoGenerator lottoGenerator = new LottoGenerator();
    public void startProgram() {
        int purchaseAmount = SystemUi.getPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        SystemUi.printLotto(lottos);
    }
}
