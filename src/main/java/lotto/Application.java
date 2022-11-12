package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();

        user.inputPurchaseMoney();
        user.purchaseLotto();
        lottoMachine.inputWinningNumber();
        lottoMachine.inputBonusNumber();
    }
}
