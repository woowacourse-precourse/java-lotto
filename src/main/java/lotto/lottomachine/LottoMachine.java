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

    private static final int EXCEPTION_NUMBER = -1;
    private static final int INIT_MONEY = 0;
    private int lottoPrice;
    private boolean machineStatus;

    public LottoMachine() {
        lottoPrice = INIT_MONEY;
        machineStatus = true;
    }

    public void start() {
        buyLotto();
        LottoPaper lottoPaper = GeneratorLottoPaper.generateLottoPaper(lottoPrice);
        List<Integer> userNumbers = inputLottoNumbers();
        Integer bonus = inputBonus();
        showStats(lottoPaper, userNumbers, bonus);
    }

    public void showStats(LottoPaper lottoPaper, List<Integer> userNumbers, Integer bonus) {
        if (machineStatus) {
            List<Integer> ranks = lottoPaper.checkLottos(userNumbers, bonus);
            OutputView.showResult(ranks, lottoPrice);
        }
    }

    public void buyLotto() {
        String userLottoPrice = InputView.buyLotto();
        try {
            UserMoneyValidation.validate(userLottoPrice);
            lottoPrice = Integer.parseInt(userLottoPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lottoPrice = EXCEPTION_NUMBER;
            machineStatus = false;
        }
    }

    public List<Integer> inputLottoNumbers() {
        if (!machineStatus) {
            return Collections.emptyList();
        }
        return inputUserNumbers();
    }

    public List<Integer> inputUserNumbers() {
        try {
            List<Integer> userLottoNumbers = InputView.inputLottoNumbers();
            LottoNumbersValidation.validateLottoNumbers(userLottoNumbers);
            return userLottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            machineStatus = false;
        }
        return Collections.emptyList();
    }

    public Integer inputBonus() {
        if (!machineStatus) {
            return EXCEPTION_NUMBER;
        }
        return inputUserBonus();
    }

    public Integer inputUserBonus() {
        String bonus = InputView.inputBonusNumber();
        try {
            LottoBonusValidation.validate(bonus);
            return Integer.valueOf(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return EXCEPTION_NUMBER;
    }
}
