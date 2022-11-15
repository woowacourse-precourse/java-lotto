package lotto.model.Issue;

import lotto.model.Lotto;

import java.math.BigDecimal;
import java.util.List;

public interface LottoIssue {
    List<Lotto> getLotto();

    BigDecimal getCount();
}
