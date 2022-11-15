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
        Map<Numbers, Integer> ranking = rank(lottos, bonus);
    }

    public List<Numbers> countWinNumber(List<Lotto> lottos, Bonus bonusLotto) {
        List<Numbers> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int count = bonusLotto.count(lotto);
            boolean bonus = checkBonus(count, bonusLotto, lotto);
            result.add(Numbers.findRank(count, bonus));
        }

        return result;
    }

    public boolean checkBonus(int count, Bonus bonus, Lotto lotto) {
        boolean isBonus = false;

        if (count == 5) {
            isBonus = bonus.checkBonus(lotto);
        }

        return isBonus;
    }

    public Map<Numbers, Integer> rank(List<Lotto> lottos, Bonus bonus) {
        List<Numbers> winningRanks = countWinNumber(lottos, bonus);
        Map<Numbers, Integer> rankList = new HashMap<>();
        for (Numbers rank : winningRanks) {
            rankList.put(rank, rankList.getOrDefault(rank, 0) + 1);
        }

        return rankList;
    }
}
