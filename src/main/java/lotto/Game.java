package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public void playGame() {
        Print.inputMoney();
        int numberOfLottos = Input.inputPurchaseMoney();
        Print.outputNumberOfLotto(numberOfLottos);
        List<Lotto> lottos = Lotto.issueLotto(numberOfLottos);
        Print.printLottos(lottos);
        Print.winningNumber();
        Lotto winning = Input.inputWinningNumber();
    }
}
