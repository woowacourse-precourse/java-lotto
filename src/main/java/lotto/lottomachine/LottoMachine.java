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
    private boolean machineStatus;

    public LottoMachine() {
        lottoPrice = INIT_NUMBER;
        userNumbers = Collections.emptyList();
        userBonus = INIT_NUMBER;
        machineStatus = true;
    }

    public void start() {
        buyLotto();
        LottoPaper lottoPaper = GeneratorLottoPaper.generateLottoPaper(lottoPrice);
        inputLottoNumbers();
        inputBonus();
        showStats(lottoPaper);
    }

    public void showStats(LottoPaper lottoPaper) {
        if (machineStatus) {
            List<Integer> ranks = lottoPaper.checkLottos(userNumbers, userBonus);
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
            machineStatus = false;
        }
    }

    public void inputLottoNumbers() {
        if (!machineStatus) {
            return;
        }
        inputUserNumbers();
    }

    public void inputUserNumbers() {
        try {
            List<Integer> inputLottoNumbers = InputView.inputLottoNumbers();
            LottoNumbersValidation.validateLottoNumbers(inputLottoNumbers);
            userNumbers =  inputLottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            machineStatus = false;
        }
    }

    public void inputBonus() {
        if (!machineStatus) {
            return;
        }
        inputUserBonus();
    }

    public void inputUserBonus() {
        String bonus = InputView.inputBonusNumber();
        try {
            LottoBonusValidation.validate(bonus);
            LottoBonusValidation.validateDuplicateNumber(userNumbers, bonus);
            userBonus =  Integer.valueOf(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            machineStatus = false;
        }
    }
}
