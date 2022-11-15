package lotto.domain.seller;

import java.util.List;
import lotto.domain.lotto.LottoRanking;
import lotto.dto.LottoCount;

public interface Seller {

    int compareNumbers(List<Integer> numbers);

    boolean compareBonusNumber(List<Integer> numbers);

    LottoRanking findLottoRanking(LottoCount lottoCount);

    int calculateTotalWinningAmount(List<LottoRanking> lottoRankings);
}
