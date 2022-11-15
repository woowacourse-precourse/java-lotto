package lotto.Controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.WinningNumber;

import java.util.List;

public class LottoGame {

    LottoMachine lottoMachine = new LottoMachine();
    WinningNumber winningNumber = new WinningNumber();

    public void run() {
        try {
            int money = lottoMachine.insertMoney();
            List<Lotto> lottoBought = lottoMachine.createLotto(money);
            lottoMachine.printLottoBought(lottoBought);

            List<Integer> luckyNumbers = winningNumber.createLuckyNumber();
            int bonusNumber = winningNumber.createBonusNumber(luckyNumbers);
            lottoMachine.compareLotto(lottoBought, luckyNumbers, bonusNumber);
            lottoMachine.printResult(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
