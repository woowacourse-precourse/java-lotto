package lotto.view.output;

import lotto.model.Lotto;
import lotto.model.statistics.Statistics;
import lotto.utils.EventMessage;

import java.util.List;

public interface Output {

    void printErrorMessage(IllegalArgumentException exception);
    void printEventMessage(EventMessage eventMessage);
    void printIssuedLotto(List<Lotto> issuedLotto);
    void printStatistics(Statistics statistics);
}
