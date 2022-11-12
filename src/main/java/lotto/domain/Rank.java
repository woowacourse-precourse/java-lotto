package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Rank {

    public static List<Integer> makeRank(List<Lotto> lottoNumbers, List<Integer> winNumbers, int bonus) {
        List<Integer> ranked = new ArrayList<>();
        for (Lotto lotto : lottoNumbers) {
            ranked.add(rankNumber(lotto, winNumbers, bonus));
        }
        return ranked;
    }

    private static int rankNumber(Lotto lotto, List<Integer> winNumbers, int bonus) {
        int ranking = lotto.value().stream()
                .filter(number -> winNumbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList()).size();
        if (ranking == 5) {
            ranking += matchBonus(lotto, bonus);
        }
        return ranking;
    }

    private static int matchBonus(Lotto lotto, int bonus) {
        if (lotto.value().contains(bonus)) {
            return 2;
        }
        return 0;
    }
}
