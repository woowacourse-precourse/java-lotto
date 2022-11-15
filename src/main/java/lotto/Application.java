package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        User user = new User(lottoMachine);

        user.inputMoney();
        lottoMachine.setWinningNumber();
        lottoMachine.setBonusNumber();
        user.printWinningStatistics();



    }
}
