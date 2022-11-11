package lotto.Domain;

import Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int money;
    private int lottoCount;
    private Lotto playerLotto;
    private int playerBonusNumber;
    private List<Lotto> Lottos;

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void setLottoCount(int money) {
        final int THOUSAND_WON = 1000;
        this.lottoCount = money / THOUSAND_WON;
    }

    public void setLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomUtils.getRandomLottoNumber()));
        }
        this.Lottos = lottos; 
    }
}
