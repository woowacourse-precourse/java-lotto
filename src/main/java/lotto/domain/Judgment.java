package lotto.domain;

import java.util.List;

public interface Judgment {

    int correctCount(List<Integer> userNumbers, List<Integer> priceNumbers);

    boolean hasBonusNumber(List<Integer> userNumbers, int bonusNumber);
}
