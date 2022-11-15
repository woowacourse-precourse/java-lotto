package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoUser;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoAnalyzer {

    private final static Map<LottoRank, Integer> winningStatus;
    private final LottoUser lottoUser;
    private final Lotto winningLotto;
    private final int bonusNumber;

    static {
        winningStatus = new TreeMap<>(Collections.reverseOrder());
        List.of(LottoRank.values()).forEach(rank -> winningStatus.put(rank, 0));
    }

    public LottoAnalyzer(final LottoUser lottoUser, final Lotto winningLotto, final int bonusNumber) {
        this.lottoUser = lottoUser;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
