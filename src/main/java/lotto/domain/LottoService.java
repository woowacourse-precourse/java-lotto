package lotto.domain;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public interface LottoService {

    Map<Rank, Integer> compare(List<Lotto> userLottos, Lotto prizeLotto, int bonusNumber);

    double calculateRate(Map<Rank, Integer> results, int amount);
}
