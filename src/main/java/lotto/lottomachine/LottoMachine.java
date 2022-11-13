package lotto.lottomachine;

import java.util.Collections;
import java.util.List;
import lotto.domain.validation.LottoNumbersValidation;
import lotto.lottopaper.LottoPaper;
import lotto.user.User;
import lotto.user.UserUtil;
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
        List<Integer> userNumbers = inputUserNumbers();
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

    public List<Integer> inputUserNumbers() {
        if (!machineStatus) {
            return Collections.emptyList();
        }
        try {
            String userLottoNumbers = User.inputLottoNumbers();
            List<Integer> lottoNumbers = UserUtil.convertUserInputToNumbers(userLottoNumbers);
            LottoNumbersValidation.validateLottoNumbers(lottoNumbers);
            return lottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            machineStatus = false;
        }
        return Collections.emptyList();
    }
}
