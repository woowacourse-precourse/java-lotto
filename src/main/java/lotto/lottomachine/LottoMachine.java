package lotto.lottomachine;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.validation.LottoBonusValidation;
import lotto.lottopaper.LottoPaper;
import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.view.validation.InputMoneyValidation;

public class LottoMachine {

    private static final int INIT_NUMBER = 0;
    private int lottoPrice;
    private Lotto userLotto;
    private Integer userBonus;

    public LottoMachine() {
        lottoPrice = INIT_NUMBER;
        userBonus = INIT_NUMBER;
    }

    public void start() {
        try {
            buyLotto();
            LottoPaper lottoPaper = GeneratorLottoPaper.generateLottoPaper(lottoPrice);
            inputUserNumbers();
            inputUserBonus();
            showStats(lottoPaper);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showStats(LottoPaper lottoPaper) {
            List<Integer> ranks = lottoPaper.checkLottos(userLotto, userBonus);
            OutputView.showResult(ranks, lottoPrice);
    }

    public void buyLotto() {
        String userLottoPrice = InputView.buyLotto();
        InputMoneyValidation.validate(userLottoPrice);
        lottoPrice = Integer.parseInt(userLottoPrice);
    }

    public void inputUserNumbers() {
        List<Integer> inputLottoNumbers = InputView.inputLottoNumbers();
        userLotto =  new Lotto(inputLottoNumbers);
    }

    public void inputUserBonus() {
        Integer bonus = InputView.inputBonusNumber();
        LottoBonusValidation.validate(bonus);
        LottoBonusValidation.validateDuplicateNumber(userLotto, bonus);
        userBonus = bonus;
    }
}
