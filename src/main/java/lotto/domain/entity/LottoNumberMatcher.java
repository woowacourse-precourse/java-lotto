package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.vo.MatchReport;

public class LottoNumberMatcher {

    public LottoNumberMatcher() {
    }

    public List<MatchReport> match(Lottos userLottos, LottoMachine machine) {
        List<MatchReport> matchReports = new ArrayList<>();

        List<Lotto> userWholeLottos = userLottos.currentLottos();
        int bonusNumber = machine.currentBonusNumber();
        Lotto winningLotto = machine.currentMachineNumbers();

        for (Lotto userLotto : userWholeLottos) {
            MatchReport matchReport = winningLotto.matchNumbers(userLotto, bonusNumber);
            matchReports.add(matchReport);
        }

        return matchReports;
    }
}
