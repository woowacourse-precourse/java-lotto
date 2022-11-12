package lotto.helper.factory.stub;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.util.ranking.LottoRanking;

public class StubWinningLotto extends Lotto {

    private final List<LottoRanking> returnLottoRanking;
    private int returnIndex = 0;

    public StubWinningLotto(List<LottoRanking> returnLottoRanking) {
        super(List.of(1, 2, 3, 4, 5, 6));
        this.returnLottoRanking = returnLottoRanking;
    }

    @Override
    public LottoRanking calculateLottoGrade(Lotto playerLotto, LottoNumber bonusNumber) {
        return returnLottoRanking.get(returnIndex++);
    }
}
