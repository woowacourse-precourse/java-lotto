package lotto.domain;

import lotto.service.LottoGenerator;

import java.util.List;

public class User {
    private final LottoGenerator lottoGenerator;
    private List<Lotto> lottoList;

    public User() {
        this.lottoGenerator = new LottoGenerator();
    }

}
