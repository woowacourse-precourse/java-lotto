package lotto.dto;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLottoNumbers;

import java.util.Collections;
import java.util.List;

public class LottoRanksDTO {
    private final List<LottoRank> lottoRanks;
    
    public LottoRanksDTO(final Lottos lottos, final WinningLottoNumbers winningLottoNumbers) {
        this.lottoRanks = lottos.parseRanks(winningLottoNumbers);
    }
    
    public List<LottoRank> getLottoRanks() {
        return Collections.unmodifiableList(lottoRanks);
    }
}
