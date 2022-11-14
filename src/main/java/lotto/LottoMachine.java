package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public HashMap<Rank, Integer> makeRankResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        HashMap<Rank, Integer> rankResult = new HashMap<>();
        for (int i = 0; i < lottos.size(); i++) {
            Rank rank = lottos.get(i).matchRank(winningNumber, bonusNumber);
            if (!rankResult.containsKey(rank)) {
                rankResult.put(rank, 0);
            }
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
        return rankResult;
    }
}
