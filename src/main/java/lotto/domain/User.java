package lotto.domain;

import lotto.service.LottoGenerator;

import java.util.List;

public class User {
    private final List<Lotto> purchasedLotto;
    private Statistics statistics;

    public User() {
        this.lottoGenerator = new LottoGenerator();
    }

}
