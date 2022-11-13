package lotto.lottomachine;

import java.util.Collections;
import java.util.List;
import lotto.domain.validation.LottoNumbersValidation;
import lotto.lottopaper.LottoPaper;
import lotto.user.User;
import lotto.user.validation.UserMoneyValidation;

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
    }

    public void buyLotto() {
        String userLottoPrice = User.buyLotto();
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
            List<Integer> userLottoNumbers = User.inputLottoNumbers();
            LottoNumbersValidation.validateLottoNumbers(userLottoNumbers);
            return userLottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            machineStatus = false;
        }
        return Collections.emptyList();
    }
}
