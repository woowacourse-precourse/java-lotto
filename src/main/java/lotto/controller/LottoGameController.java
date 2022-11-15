package lotto.controller;

import static lotto.view.Input.inputBonusNumber;
import static lotto.view.Input.inputPurchaseAmount;
import static lotto.view.Input.inputWinningNumbers;
import static lotto.view.Print.printLottoResult;
import static lotto.view.Print.printPublishedLottoNumbers;
import static lotto.view.Print.printPurchaseQuantity;
import static lotto.view.Print.printYield;
import static lotto.view.Print.requestBonusNumberInput;
import static lotto.view.Print.requestPurchaseAmountInput;
import static lotto.view.Print.requestWinningNumbersInput;

import java.util.List;
import java.util.Map;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoRank;
import lotto.model.LottoReader;

public class LottoGameController {
    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoReader lottoReader = new LottoReader();

    public void start() {
        requestPurchaseAmountInput();
        int purchaseAmount = inputPurchaseAmount();

        List<Lotto> publishedAllLotto = publishLotto(purchaseAmount);
        Lotto winningLotto = publishWinningLotto();
        Bonus bonus = publishBonus(winningLotto);

        makeWinningResult(publishedAllLotto, winningLotto, bonus);
        makeYield(purchaseAmount);
    }

    private void makeYield(int purchaseAmount) {
        double lottoYield = lottoReader.calculateYield(purchaseAmount);
        printYield(lottoYield);
    }

    private void makeWinningResult(List<Lotto> publishedAllLotto, Lotto winningLotto, Bonus bonus) {
        Map<LottoRank, Integer> lottoResult = lottoReader.createLottoResult(publishedAllLotto, winningLotto, bonus);
        printLottoResult(lottoResult);
    }

    private Bonus publishBonus(Lotto winningLotto) {
        requestBonusNumberInput();
        return lottoMachine.publishBonus(inputBonusNumber(), winningLotto);
    }

    private Lotto publishWinningLotto() {
        requestWinningNumbersInput();
        return lottoMachine.publishWinningLotto(inputWinningNumbers());
    }

    private List<Lotto> publishLotto(int purchaseAmount) {
        lottoMachine.inputMoney(purchaseAmount);
        List<Lotto> publishedAllLotto = lottoMachine.publishLotto();

        printPurchaseQuantity(publishedAllLotto.size());
        printPublishedLottoNumbers(publishedAllLotto);

        return publishedAllLotto;
    }
}
