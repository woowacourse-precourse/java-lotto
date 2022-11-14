package lotto.view.outputView;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputViewImple implements OutputView {

    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";

    @Override
    public void printPurchasedLottos(List<Lotto> lottos) {
        printPurchasedAmount(lottos);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private void printPurchasedAmount(List<Lotto> lottos) {
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, lottos.size()));
    }

    @Override
    public void printWinningStatus(Map<Rank, Integer> winningStatus) {
        //TODO: 구현
    }


    @Override
    public void printReturnRatio(double returnRatio) {
        //TODO: 구현
    }

    @Override
    public void printErrorMessage(Exception e) {
        //TODO: 구현
    }


}
