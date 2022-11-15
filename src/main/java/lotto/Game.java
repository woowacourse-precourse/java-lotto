package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    public void playGame() {
        Print.inputMoney();
        int numberOfLottos = Input.inputPurchaseMoney();
        Print.outputNumberOfLotto(numberOfLottos);
        LottoList lottos = Lotto.issueLotto(numberOfLottos);
        Print.printLottos(lottos);
        Print.winningNumber();
        Lotto winning = Input.inputWinningNumber();
        Print.bonusNumber();
        int bonusNumber = Input.inputBonusNumber();
        Bonus bonus = new Bonus(winning, bonusNumber);
        Map<Numbers, Integer> ranking = rank(lottos, bonus);
        Print.printResult(numberOfLottos, ranking);
    }

    public static List<Numbers> countWinNumber(Bonus bonusLotto, LottoList lottos) {
        List<Numbers> result = new ArrayList<>();

        for (Lotto lotto : lottos.getLottos()) {
            int count = bonusLotto.count(lotto);
            boolean bonus = checkBonus(count, bonusLotto, lotto);
            result.add(Numbers.findRank(count, bonus));
        }

        return result;
    }

    public static boolean checkBonus(int count, Bonus bonus, Lotto lotto) {
        boolean isBonus = false;

        if (count == 5) {
            isBonus = bonus.checkBonus(lotto);
        }

        return isBonus;
    }

    public Map<Numbers, Integer> rank(LottoList lottos, Bonus bonus) {
        List<Numbers> winningRanks = countWinNumber(bonus, lottos);
        Map<Numbers, Integer> rankList = initRankList();
        for (Numbers rank : winningRanks) {
            rankList.put(rank, rankList.getOrDefault(rank, 0) + 1);
        }

        return rankList;
    }

    private Map<Numbers, Integer> initRankList() {
        Map<Numbers, Integer> rankList = new HashMap<>();

        rankList.put(Numbers.NOTHING, 0);
        rankList.put(Numbers.THREE, 0);
        rankList.put(Numbers.FOUR, 0);
        rankList.put(Numbers.FIVE, 0);
        rankList.put(Numbers.FIVE_WITH_BONUS, 0);
        rankList.put(Numbers.SIX, 0);

        return rankList;
    }
}
