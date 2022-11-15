package lotto.domain;

import java.util.List;

public class LottoCard {

    private long lottoCardNum;

    public LottoCard(long money) {
        lottoCardNum = money / 1000;
    }

    private void generateRandomLottoNum() {
        for (int i = 0; i < lottoCardNum; i++) {
            new RandomNumberGenerator();
        }
    }

}
