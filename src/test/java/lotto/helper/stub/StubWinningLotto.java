package lotto.helper.stub;

import java.util.List;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.mvc.util.LottoRanking;

public class StubWinningLotto extends Lotto {

    private final List<LottoRanking> returnLottoRanking;
    private int returnIndex = 0;

    public StubWinningLotto(List<LottoRanking> returnLottoRanking) {
        super(List.of(1, 2, 3, 4, 5, 6));
        this.returnLottoRanking = returnLottoRanking;
    }

    @Override
    public LottoRanking calculateLottoGrade(Lotto playerLotto, LottoNumber bonusNumber) {
        if (returnIndex < returnLottoRanking.size()) {
            return returnLottoRanking.get(returnIndex++);
        }
        return LottoRanking.RANKING_NOTHING;
    }


}
