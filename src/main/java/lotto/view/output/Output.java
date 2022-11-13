package lotto.view.output;

import java.util.List;
import lotto.domain.lotto.lotto.Lotto;

public interface Output {

    void printMessage(String outputMessage);

    void printPublishedLotto(List<Lotto> publishedLotto);
}
