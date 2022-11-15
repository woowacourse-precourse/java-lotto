package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private static final int ZERO = 0;

    private final List<Lotto> lottery;

    public Lottery(int lottoCount) {
        this.lottery = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();

        for (int i = ZERO; i < lottoCount; i++) {
            lottery.add(lottoGenerator.generateLotto());
        }
    }

    public List<Lotto> getLottery() {
        return lottery;
    }
}
