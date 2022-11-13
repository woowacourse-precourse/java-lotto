package lotto.lottomachine;

import java.util.Collections;
import java.util.List;
import lotto.domain.validation.LottoBonusValidation;
import lotto.domain.validation.LottoNumbersValidation;
import lotto.lottopaper.LottoPaper;
import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.view.validation.UserMoneyValidation;

public class LottoMachine {

    private static final int INIT_NUMBER = 0;
    private int lottoPrice;
    private List<Integer> userNumbers;
    private Integer userBonus;

    public LottoMachine() {
        lottoPrice = INIT_NUMBER;
        userNumbers = Collections.emptyList();
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
            List<Integer> ranks = lottoPaper.checkLottos(userNumbers, userBonus);
            OutputView.showResult(ranks, lottoPrice);
    }

    public void buyLotto() {
        String userLottoPrice = InputView.buyLotto();
        try {
            UserMoneyValidation.validate(userLottoPrice);
            lottoPrice = Integer.parseInt(userLottoPrice);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    public void inputUserNumbers() {
        try {
            List<Integer> inputLottoNumbers = InputView.inputLottoNumbers();
            LottoNumbersValidation.validateLottoNumbers(inputLottoNumbers);
            userNumbers =  inputLottoNumbers;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    public void inputUserBonus() {
        String bonus = InputView.inputBonusNumber();
        try {
            LottoBonusValidation.validate(bonus);
            LottoBonusValidation.validateDuplicateNumber(userNumbers, bonus);
            userBonus =  Integer.valueOf(bonus);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }
    }
}
