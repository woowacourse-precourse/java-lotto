package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.RandomNumbers;
import lotto.util.Transform;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.ArrayList;

import static lotto.validator.NumbersValidator.*;

public class LottoGame {
    private List<Lotto> purchaseLotto;
    private Lotto lottoNumbers;
    private int bonusNumber;

    public void startLottoGame() {
        int quantity = getLottoPurchaseAmount();
        OutputView.printLottoPurchaseCompleteAmount(quantity);

        purchaseLotto = buyLotto(quantity);
        OutputView.printLottoFormatting(purchaseLotto);
        lottoNumbers = setLottoNumbers();
        bonusNumber = setBonusNumber();
    }

    private int getLottoPurchaseAmount() {
        int quantity = InputView.inputLottoPurchaseAmount() / 1000;
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
        return purchaseLotto;
    }

    private Lotto setLottoNumbers() {
        Transform transform = new Transform();

        String rawInputValue = InputView.inputLottoNumbers();
        List<String> splitedNumbers = transform.splitLottoNumbers(rawInputValue);
        validateNonNumericElements(splitedNumbers);
        validateSize(splitedNumbers);

        List<Integer> numbers = transform.transformType(splitedNumbers);
        validateDuplicateNumber(numbers);
        validateRangeNumbers(numbers);

        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private int setBonusNumber() {
        int bonus = InputView.inputBonusNumber();
        validateAlreadyExist(lottoNumbers, bonus);
        return bonus;
    }
}
