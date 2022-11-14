package lotto.view.outputView;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public interface OutputView {

    void printPurchasedLottos(List<Lotto> lottos);

    void printWinningStatus(Map<Rank, Integer> winningStatus);

    void printReturnRatio(double returnRatio);

    void printErrorMessage(Exception e);

}
