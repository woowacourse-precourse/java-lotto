package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        LottoMachine lottoMachine = new LottoMachine();

        user.inputPurchaseMoney();
        user.purchaseLotto();
        List<Integer> winningNumber = lottoMachine.inputWinningNumber();
        int bonusNumber = lottoMachine.inputBonusNumber();
    }
}
