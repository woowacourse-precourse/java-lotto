package lotto.utils;

import lotto.domain.BuyLotto;
import lotto.domain.Lotto;
import lotto.domain.Rule;

import java.util.Map;
import java.util.function.Predicate;

public classMatchCount {

    public static Rule get(BuyLotto buyLotto, Map<Integer, Lotto> temp) {
        temp.entrySet().stream().filter(i -> buyLotto.getLottos().stream().anyMatch(Predicate.isEqual(i))).count();
        return null;
    }
}
