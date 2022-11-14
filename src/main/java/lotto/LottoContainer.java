package lotto;

import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottos;

    public LottoContainer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLottos() {
        int size = lottos.size();
        System.out.println(size + "개를 구매했습니다.");
        for (Lotto lotto: lottos) {
            lotto.printNumbers();
        }
    }

}
