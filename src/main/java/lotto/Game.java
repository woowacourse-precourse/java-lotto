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
        Print.bonusNumber();
        int bonusNumber = Input.inputBonusNumber();
        Bonus bonus = new Bonus(winning, bonusNumber);
        List<Integer> result = countWinNumber(lottos, bonus);
    }

    public List<Integer> countWinNumber(List<Lotto> lottos, Bonus bonusLotto) {
        List<Integer> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            result.add(bonusLotto.count(lotto));
        }

        return result;
    }
}
