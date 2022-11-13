package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();

        user.inputPurchaseMoney();
        user.purchaseLotto();
        lottoMachine.inputWinningNumber();
        lottoMachine.inputBonusNumber();
        Result.compareLottoNumber(user.myLotto, lottoMachine.winningNumber, lottoMachine.bonusNumber, user.money);
    }
}
