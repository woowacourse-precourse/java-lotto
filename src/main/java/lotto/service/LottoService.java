package lotto.service;

import java.util.List;
import lotto.view.ExceptionMessage;
import lotto.util.LottoUtils;

public class LottoService {

    final static int LOTTO_PAYMENT = 1000;

    public int buyLotto(int payment) {
        return getLottoAmount(payment);
    }

    public int getLottoAmount(int payment) {
        if (payment % LOTTO_PAYMENT != 0) {
            ExceptionMessage.paymentUnitError();
            throw new IllegalArgumentException();
        }
        return payment / LOTTO_PAYMENT;
    }

    public List<Integer> setWinningNumber(String inputWinningNumber) {
        return LottoUtils.parsingNumberBySeparator(inputWinningNumber);
    }

    public int setBonusNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (Exception e) {
            ExceptionMessage.inputNumberError();
            throw e;
        }
    }
}
