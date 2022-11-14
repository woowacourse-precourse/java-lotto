package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.ErrorCode.INVALID_PRICE;

public class LottoSystem {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final Validator validator = new Validator();

    public LottoSystem() {}

    public void start() {
        String input = inputView.inputMoney();
        int money = validator.convertToInt(input);
        if (!validator.isValidPrice(money)) {
            throw new IllegalArgumentException(INVALID_PRICE.getMessage());
        }
        List<Lotto> userLottos = purchaseLotto(money);
        outputView.outputUserLottos(userLottos);
    }

    public void draw() {
        String inputWonNumber = inputView.inputWonNumber();
        List<Integer> wonNumber = validator.convertToIntList(inputWonNumber);
        System.out.println(wonNumber);
        Lotto wonLotto = new Lotto(wonNumber);

        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = validator.convertToInt(inputBonusNumber);
        System.out.println(bonusNumber);
    }

    private List<Lotto> purchaseLotto(int money) {
        int lottoCnt = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = new Lotto(numberGenerator.createRandomLottoNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}