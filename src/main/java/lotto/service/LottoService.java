package lotto.service;

import java.util.List;
import lotto.domain.User;
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
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public int getLottoAmount(int payment) {
        if(payment % LOTTO_PAYMENT != 0){
            throw new IllegalArgumentException("[ERROR] 로또 금액 단위로 입력해야 합니다.");
        }
        return payment/LOTTO_PAYMENT;
    }

    public List<Integer> setWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber = LottoUtils.parsingNumberBySeparator(inputWinningNumber);
        LottoUtils.checkUniqueNumbers(winningNumber);

        for(int number :winningNumber){
            LottoUtils.checkNumberInRange(number);
        }

        return winningNumber;
    }

    public int setBonusNumber(String inputBonusNumber){
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            LottoUtils.checkNumberInRange(bonusNumber);
            return bonusNumber;
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
        }
    }

    public WinningLotto setWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        WinningLotto winningLotto= new WinningLotto(winningNumber,bonusNumber);
        return winningLotto;
    }
}
