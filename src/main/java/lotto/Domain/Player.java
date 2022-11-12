package lotto.Domain;

import Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private int money;
    private int lottoCount;
    private Lotto playerLotto;
    private int playerBonusNumber;
    private List<Lotto> lottos;

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
        this.lottos = lottos;
    }

    public List<String> getLottos() {
        return this.lottos.stream()
                .map(value -> value.getLottoNumbers().toString())
                .collect(Collectors.toList());
    }
}
