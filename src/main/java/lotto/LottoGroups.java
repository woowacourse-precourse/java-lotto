package lotto;

import type.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGroups {
    private List<Lotto> lottos;

    public LottoGroups(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        List<Lotto> lottoGroups = lottos.stream().collect(Collectors.toList());
        return lottoGroups;
    }

    public List<Rank> getRanks(List<Integer> winningNumbers, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();
        lottos.stream().forEach(lotto -> ranks.add(lotto.rankOfLotto(winningNumbers, bonusNumber)));
        return ranks;
    }

    public Map<Rank, Integer> numbersOfRanks(List<Integer> winningNumbers, int bonusNumber) {
        List<Rank> ranks = getRanks(winningNumbers, bonusNumber);
        Map<Rank, Integer> numbersOfRanks = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> numbersOfRanks.put(rank, Collections.frequency(ranks, rank)));

        return numbersOfRanks;
    }
}
