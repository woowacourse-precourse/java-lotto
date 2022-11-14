package lotto.domain;

import lotto.Lotto;
import lotto.Rank;

import java.util.List;
import java.util.Map;

public interface LottoService {

    void compare(List<Lotto> userLottos, Lotto prizeLotto, int bonusNumber);

    double calculateRate(Map<Rank, Integer> results);
}
