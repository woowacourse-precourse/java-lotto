package lotto.domain;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public interface Output {

    void issuedLottos(List<Lotto> lottos);

    void results(Map<Rank, Integer> results);

    void rate(double rate);

    void exceptionMessage(IllegalArgumentException e);
}
