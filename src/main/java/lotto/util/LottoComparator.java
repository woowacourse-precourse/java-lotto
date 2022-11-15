package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;

public class LottoComparator {

    public static Map<Rank, Integer> compareToPrize(List<Lotto> lottoList, Lotto prizeLotto, int bonusNumber) {
        Map<Rank, Integer> ranked = new EnumMap<>(Rank.class);
        lottoList.stream()
                .map(l -> getLottoRank(l, prizeLotto, bonusNumber))
                .forEach(rank ->
                        ranked.put(rank, ranked.getOrDefault(rank, 0) + 1)
                );
        return ranked;
    }

    private static Rank getLottoRank(Lotto ownLotto, Lotto prizeLotto, int bonusNumber) {
        int cnt = countNumberCorrectness(ownLotto, prizeLotto);
        boolean bonus = hasBonusNumber(ownLotto, bonusNumber);

        Optional<Rank> result = Arrays.stream(Rank.values()).filter(r -> r.matchRank(cnt, bonus)).findAny();
        return result.orElse(Rank.NONE);
    }

    private static boolean hasBonusNumber(Lotto ownLotto, int bonusNumber) {
        return ownLotto.contains(bonusNumber);
    }

    private static int countNumberCorrectness(Lotto lotto, Lotto prizeLotto) {
        Set<Integer> ownLotto = lotto.toSet();
        Set<Integer> matchedLotto = prizeLotto.toSet();

        matchedLotto.removeAll(ownLotto);
        return ownLotto.size() - matchedLotto.size();
    }

    public Rank forTest_getLottoRank(Lotto ownLotto, Lotto prizeLotto, int bonusNumber) {
        return getLottoRank(ownLotto, prizeLotto, bonusNumber);
    }
}
