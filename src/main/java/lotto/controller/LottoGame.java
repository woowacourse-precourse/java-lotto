package lotto.controller;

import lotto.domain.*;
import lotto.util.Transform;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.ArrayList;

import static lotto.validator.NumbersValidator.*;

public class LottoGame {
    private Lotto lottoNumbers;

    public void startLottoGame() {
        int quantity = getLottoPurchaseAmount();
        List<Lotto> purchaseLotto = buyLotto(quantity);
        lottoNumbers = setLottoNumbers();
        int bonusNumber = setBonusNumber();

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusNumber);

        result(winningLotto, new Lottos(purchaseLotto));
    }

    private int getLottoPurchaseAmount() {
        int quantity = Integer.parseInt(InputView.inputLottoPurchaseAmount()) / 1000;
        OutputView.printLottoPurchaseCompleteAmount(quantity);
        return quantity;
    }

    private List<Lotto> buyLotto(int quantity) {
        List<Lotto> purchaseLotto = new ArrayList<>();
        RandomNumbers randomNumbers = new RandomNumbers();

        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = randomNumbers.generateRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            purchaseLotto.add(lotto);
        }
        OutputView.printLottoFormatting(purchaseLotto);
        return purchaseLotto;
    }

    private Lotto setLottoNumbers() {
        Transform transform = new Transform();

        String rawInputValue = InputView.inputLottoNumbers();
        List<String> splitedNumbers = transform.splitedNumbers(rawInputValue);
        validateNonNumericElements(splitedNumbers);
        validateSize(splitedNumbers);

        List<Integer> numbers = transform.transformType(splitedNumbers);
        validateDuplicateNumber(numbers);
        validateRangeNumbers(numbers);

        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private int setBonusNumber() {
        int bonus = Integer.parseInt(InputView.inputBonusNumber());
        validateAlreadyExist(lottoNumbers, bonus);
        return bonus;
    }

    private void result(WinningLotto winningLotto, Lottos purchaseLotto) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.getResult(winningLotto, purchaseLotto);

        lottoResult.printResult();
//        getProfit(lottoResult);
    }
}
