package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();

        try {
            user.inputPurchaseMoney();
            user.purchaseLotto();
            Lotto winningNumber = lottoMachine.inputWinningNumber();
            lottoMachine.inputBonusNumber();
            Result.compareLottoNumber(user.myLotto, winningNumber, lottoMachine.bonusNumber, user.money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            return;
        }
    }
}
