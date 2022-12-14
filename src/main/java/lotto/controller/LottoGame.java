package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.ArrayList;

import static lotto.util.Transform.convertType;
import static lotto.util.Transform.splitedNumbers;
import static lotto.validator.LottoValidator.*;

public class LottoGame {
    private int amount;

    public void startLottoGame() {
        Lottos purchaseLotto = initPurchaseLotto();
        WinningLotto winningLotto = new WinningLotto(initWinningLotto(), initBonus());
        result(winningLotto, purchaseLotto);
    }

    private void result(WinningLotto winningLotto, Lottos purchaseLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.getResult(winningLotto, purchaseLotto);

        OutputView.printLottoResult(lottoResult);
        getProfit(lottoResult);
    }

    private void getProfit(LottoResult lottoResult) {
        double profit = lottoResult.calculateProfitRate(amount);
        OutputView.printProfit(profit);
    }

    private int initLottoQuantity() {
        amount = Integer.parseInt(InputView.readPurchaseAmount());

        validateAmountRange(amount);
        validateUnit(amount);
        return amount / 1000;
    }

    private Lottos initPurchaseLotto() {
        GenerateRandomNumbersImpl generateRandomNumbers = new GenerateRandomNumbersImpl();
        List<Lotto> lottos = new ArrayList<>();

        int quantity = initLottoQuantity();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(generateRandomNumbers.generate()));
        }
        Lottos purchaseLottos = new Lottos(lottos);

        OutputView.printPurchaseQuantityMessage(quantity);
        OutputView.printPurchaseLotto(purchaseLottos.toString());
        return purchaseLottos;
    }

    private Lotto initWinningLotto() {
        String winning = InputView.readWinningNumbers();
        return new Lotto(transformInputNumbers(winning));
    }

    private List<Integer> transformInputNumbers(String winningLotto) {
        List<String> numbers = splitedNumbers(winningLotto);

        validateNonNumericNumbers(numbers);
        return convertType(numbers);
    }

    private int initBonus() {
        int bonus = Integer.parseInt(InputView.readBonusNumber());

        validateLottoNumberRange(bonus);
        return bonus;
    }
}
