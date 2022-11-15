package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static final int PRICE_OF_LOTTO = 1000;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private List<Lotto> lottos = new ArrayList<>();

    public void playLottoGame() {
        int purchasePrice = inputView.userInputPurchasePrice();
        int amountOfLotto = computeAmountOfLotto(purchasePrice);
        outputView.printAmountOfLottoMessage(amountOfLotto);

        generateLotto(amountOfLotto);
    }

    public int computeAmountOfLotto(int purchasePrice) {
        return purchasePrice / PRICE_OF_LOTTO;
    }

    public void generateLotto(int amountOfLotto) {
        LottoMachine lottoMachine = new LottoMachine();

        for (int repeatCnt = 0; repeatCnt < amountOfLotto; repeatCnt++) {
            Lotto lotto = lottoMachine.generateLotto();
            lottos.add(lotto);
        }
    }
}
