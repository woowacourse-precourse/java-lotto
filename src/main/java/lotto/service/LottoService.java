package lotto.service;

import java.util.List;
import lotto.view.ExceptionMessage;
import lotto.util.LottoUtils;

public class LottoService {

    final static int LOTTO_PAYMENT = 1000;

    public int buyLotto(int payment) {
        int amount = getLottoAmount(payment);
        return amount;
    }

    public int getLottoAmount(int payment) {
        if (payment % LOTTO_PAYMENT != 0) {
            ExceptionMessage.paymentUnitError();
            throw new IllegalArgumentException();
        }
        return payment / LOTTO_PAYMENT;
    }

    public List<Integer> setWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = LottoUtils.parsingNumberBySeparator(inputWinningNumber);

        for (int number : winningNumber) {
            LottoUtils.checkNumberInRange(number);
        }
        return winningNumber;
    }

    public int setBonusNumber(String inputBonusNumber) {
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            LottoUtils.checkNumberInRange(bonusNumber);
            return bonusNumber;
        } catch (Exception e) {
            ExceptionMessage.inputNumberError();
            throw e;
        }
    }
}
