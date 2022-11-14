package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.util.LottoUtils;

public class LottoService {

    final static int LOTTO_PAYMENT = 1000;

    public int buyLotto(String inputPayment){
        int payment = inputPaymentToNumber(inputPayment);
        int amount = getLottoAmount(payment);
        return amount;
    }

    public int inputPaymentToNumber(String inputPayment){
        int payment;

        try {
            payment = Integer.parseInt(inputPayment);
            return payment;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int getLottoAmount(int payment) {
        if(payment % LOTTO_PAYMENT != 0){
            throw new IllegalArgumentException();
        }
        return payment/LOTTO_PAYMENT;
    }

    public Lotto setWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = LottoUtils.parsingNumberBySeparator(inputWinningNumber);
        LottoUtils.checkUniqueNumbers(winningNumber);

        for(int number :winningNumber){
            LottoUtils.checkNumberInRange(number);
        }
        Lotto winningLotto = new Lotto(winningNumber);
        return winningLotto;
    }

    public int setBonusNumber(String inputBonusNumber){
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            LottoUtils.checkNumberInRange(bonusNumber);
            return bonusNumber;
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public void setWinningLotto(Lotto winningLotto, int bonusNumber) {
        new WinningLotto(winningLotto,bonusNumber);
    }
}
