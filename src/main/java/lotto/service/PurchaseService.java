package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputConsole;
import lotto.view.OutputConsole;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static lotto.utils.Constant.ONE_LOTTO_AMOUNT;

public class PurchaseService {
    private final InputConsole inputConsole;
    private final OutputConsole outputConsole;
    private final LottoNumberGenerator lottoNumberGenerator;

    public PurchaseService() {
        this.inputConsole = new InputConsole();
        this.outputConsole = new OutputConsole();
        this.lottoNumberGenerator = LottoNumberGenerator.getInstance();
    }

    public List<Lotto> purchase() {
        String purchaseAmount = inputConsole.enterPurchaseAmount();
        List<Lotto> lottos = createLotto(parseInt(purchaseAmount) / ONE_LOTTO_AMOUNT);
        outputConsole.checkPurchaseLotto(lottos);
        return lottos;
    }

    private List<Lotto> createLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
