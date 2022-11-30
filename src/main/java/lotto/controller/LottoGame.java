package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.RandomNumbers;
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

        LottoResult lottoResult = getResult(purchaseLotto, lottoNumbers, bonusNumber);
        List<Integer> result = lottoResult.getResult();

        printResult(result, quantity);
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

    private LottoResult getResult(List<Lotto> purchaseLotto, Lotto lottoNumbers, int bonusNumber) {
        return new LottoResult(purchaseLotto, lottoNumbers, bonusNumber);
    }

    private void printResult(List<Integer> result, int quantity) {
        OutputView.printWinningHistory(result);
        OutputView.printGrossProfit(result, quantity * 1000);
    }
}
