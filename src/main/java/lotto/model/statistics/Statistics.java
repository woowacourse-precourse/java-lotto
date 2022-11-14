package lotto.model.statistics;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.math.BigDecimal;
import java.util.List;

public interface Statistics {

    void calculate();
    String generateMessage();
}
