package lotto.controller;

import lotto.model.Calculator;
import lotto.model.Lotto;
import lotto.model.NumberGenerator;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.ErrorCode.*;

public class LottoSystem {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final Validator validator = new Validator();

    public LottoSystem() {}

    public List<Lotto> purchaseLotto() {
        String input = inputView.inputMoney();
        int money = validator.convertToInt(input);
        if (!validator.isThousandMultiples(money)) {
            throw new IllegalArgumentException(INVALID_PRICE.getMessage());
        }

        List<Lotto> userLottos = createLotto(money);
        outputView.outputUserLottos(userLottos);

        return userLottos;
    }

    public List<?> drawLotto() {
        String inputWonNumber = inputView.inputWonNumber();
        List<Integer> wonNumber = validator.convertToIntList(inputWonNumber);
        Lotto wonLotto = new Lotto(wonNumber);

        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = validator.convertToInt(inputBonusNumber);
        validateBonusNumber(wonNumber, bonusNumber);

        return List.of(wonLotto, bonusNumber);
    }

    public void getLottoResult(List<Lotto> userLottos, List<?> wonLottoInfo) {
        Lotto wonLotto = (Lotto) wonLottoInfo.get(0);
        int bonusNumber = (int) wonLottoInfo.get(1);

        Calculator calculator = new Calculator(wonLotto, bonusNumber, userLottos);
        int[] ranks = calculator.countLottoRanks(userLottos);
        outputView.outputLottoResult(ranks);

        double earningRate = calculator.calculateEarningRate();
        outputView.outputEarningRate(earningRate);
    }

    private List<Lotto> createLotto(int money) {
        int lottoCnt = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    private void validateBonusNumber(List<Integer> wonNumber, int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
        if (wonNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}