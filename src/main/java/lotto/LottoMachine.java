package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> buy(int money) {
        List<Lotto> buyLotto = new ArrayList<>();
        int numberOfLotto = money / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            buyLotto.add(new Lotto(generateNumber()));
        }
        return buyLotto;
    }

    private List<Integer> generateNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public Map<Rank, Integer> makeRankResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        Map<Rank, Integer> rankResult = new LinkedHashMap<Rank, Integer>() {
            {
                put(Rank.FIFTH, 0);
                put(Rank.FOURTH, 0);
                put(Rank.THIRD, 0);
                put(Rank.SECOND, 0);
                put(Rank.FIRST, 0);
                put(Rank.NOTHING, 0);
            }
        };
        for (int i = 0; i < lottos.size(); i++) {
            Rank rank = lottos.get(i).matchRank(winningNumber, bonusNumber);
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
        return rankResult;
    }
}
