package lotto.domain;

import lotto.Lotto;

import java.util.List;

public interface Judgment {

    int correctCount(List<Integer> userNumbers, List<Integer> priceNumber);

    boolean hasBonusNumber(List<Integer> userNumbers, int bonusNumber);
}
