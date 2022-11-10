package lotto.domain.entity;

import java.util.List;
import lotto.domain.vo.MatchReport;

public class LottoNumberMatcher {
    private LottoMachine lottoMachine;

    public LottoNumberMatcher() {

    }

    public List<MatchReport> match(Lottos userLottos, LottoMachine machine) {
        List<Lotto> userWholeLottos = userLottos.currentLottos();

        return null;
    }
}
