package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;
    private final Map<Rank, Integer> rankStatistic;

    public Lottos(List<Integer> numbers) {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(numbers));
        rankStatistic = new HashMap<>();
    }

    public Lottos(int lottoCount) {
        lottos = new ArrayList<>();
        rankStatistic = new HashMap<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void checkRankStatistic(List<Integer> winningNumbers, int bonusNumber) {
        lottos.forEach((lotto) -> {
            Rank rank = lotto.checkRank(winningNumbers, bonusNumber);
            rankStatistic.put(rank, rankStatistic.getOrDefault(rank, 0) + 1);
        });
    }

    public String lottosToString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach((lotto) -> sb.append(lotto.numbersToString()).append("\n"));
        return sb.toString();
    }

    public Map<Rank, Integer> getRankStatistic() {
        return rankStatistic;
    }
}