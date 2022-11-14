package lotto;

import type.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoGroups {
    private List<Lotto> lottos;

    public LottoGroups(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Rank> getRanks(List<Integer> winningNumbers, int bonusNumber){
        List<Rank> ranks = new ArrayList<>();
        lottos.stream().forEach(lotto -> ranks.add(lotto.rankOfLotto(winningNumbers, bonusNumber)));
        return ranks;
    }

    public void printAmountOfLottosComment() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printAllLottos() {
        this.lottos.stream().forEach(lotto -> System.out.println(lotto.getLotto()));
    }
}
