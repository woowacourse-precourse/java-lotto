package lotto.domain;

import lotto.domain.winning.WinningRank;

import java.util.Map;

public class LottoResult {

    private final Map<WinningRank, Integer> result;

    public LottoResult(Map<WinningRank, Integer> result) {
        this.result = result;
    }


}
