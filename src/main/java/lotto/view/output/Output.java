package lotto.view.output;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.lotto.Lotto;
import lotto.domain.lotto.lottocompany.Win;

public interface Output {

    void printMessage(String outputMessage);

    void printPublishedLotto(List<Lotto> publishedLotto);

    void printLottoResult(Map<Win, Integer> winResult, double rateOfReturn);
}
