package lotto.helper.stub;

import java.util.List;
import lotto.domain.game.LottoRanking;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;

public class StubLotto extends Lotto {

    private final List<LottoRanking> returnLottoRanking;
    private int returnIndex = 0;

    public StubLotto(List<LottoRanking> returnLottoRanking) {
        super(List.of(1, 2, 3, 4, 5, 6));
        this.returnLottoRanking = returnLottoRanking;
    }

    @Override
    public LottoRanking calculateLottoRanking(Lotto playerLotto, LottoNumber bonusNumber) {
        if (returnIndex < returnLottoRanking.size()) {
            return returnLottoRanking.get(returnIndex++);
        }
        return LottoRanking.NOTHING;
    }
}
