package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.lotto.Lotto;
import lotto.domain.lotto.lottocompany.Win;

public class OutputImpl implements Output {

    @Override
    public void printMessage(String outputMessage) {
        System.out.println(outputMessage);
    }

    @Override
    public void printPublishedLotto(List<Lotto> publishedLotto) {
        System.out.println(publishedLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : publishedLotto) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    @Override
    public void printLottoResult(Map<Win, Integer> winResult, double rateOfReturn) {
        System.out.println("당첨 통계\n" + "---");

        for (Win win : winResult.keySet()) {
            System.out.println(
                    win.getPrizeInformation() + " (" + win.getPrizeMoneyTag() + ") - " + winResult.get(win) + "개");
        }
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
