package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoUser;
import org.assertj.core.groups.Tuple;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static lotto.util.ConstValue.LottoConst.MIN_MATCHING_NUMBER_TO_WIN;

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
        makeWinningStatus();
    }

    private void makeWinningStatus() {
        lottoUser.getRandomLottos().stream()
                .filter(this::winLottoFilter)
                .forEach(numbers -> {
                    final int matchingCount = numbers.getMatchingNumberCount(winningLotto);
                    final boolean bonusMatch = numbers.existsMatchingNumber(bonusNumber);
                    final LottoRank lottoRank = LottoRank.getLottoRank(new Tuple(matchingCount, bonusMatch));
                    winningStatus.put(lottoRank, winningStatus.get(lottoRank) + 1);
                });
    }

    private boolean winLottoFilter(final Lotto lotto) {
        return lotto.getMatchingNumberCount(winningLotto) >= MIN_MATCHING_NUMBER_TO_WIN;
    }
}
