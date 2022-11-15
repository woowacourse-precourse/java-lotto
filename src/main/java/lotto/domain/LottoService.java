package lotto.domain;

import lotto.Lotto;
import lotto.PrizeNumber;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public interface LottoService {

    Map<Rank, Integer> compare(List<Lotto> issuedLottos, PrizeNumber prizeNumber);

    double calculateRate(Map<Rank, Integer> results, int amount);
}
