package lotto;

import java.util.List;

public class LottoGroups {
    private List<Lotto> lottos;

    public LottoGroups(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public void printAmountOfLottosComment() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printAllLottos() {
        this.lottos.stream().forEach(lotto -> System.out.println(lotto.getLotto()));
    }
}
