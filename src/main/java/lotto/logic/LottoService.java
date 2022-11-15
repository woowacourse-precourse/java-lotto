package lotto.logic;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;
import lotto.domain.Rank;
import lotto.domain.Winning;

public class LottoService {

    private static class LottoServiceHolder {
        private static final LottoService INSTANCE = new LottoService();
    }

    private LottoService() {

    }

    public static LottoService getInstance() {
        return LottoServiceHolder.INSTANCE;
    }

    public Map<Rank, Integer> getResult(List<Lotto> lottos, Winning target) {
        Map<Rank, Integer> countOfPlace = new EnumMap<>(Rank.class);

        lottos.forEach(lotto -> {
            Optional<Rank> optionalWinning = getWinning(target, lotto);

            if (optionalWinning.isPresent()) {
                Rank rank = optionalWinning.get();
                int newCount = countOfPlace.getOrDefault(rank, 0) + 1;
                countOfPlace.put(rank, newCount);
            }
        });

        return countOfPlace;
    }

    private Optional<Rank> getWinning(Winning target, Lotto lotto) {
        int sameCount = compareForSame(target, lotto);
        int bonusCount = compareForBonus(target, lotto);
        return Rank.getWinning(sameCount, bonusCount);
    }

    private int compareForSame(Winning target, Lotto lotto) {
        int sameCount = 0;

        for (int size = LottoInfo.SIZE.value(), i = 0; i < size; i++) {
            int number = lotto.get(i);

            if (target.contains(number)) {
                sameCount++;
            }
        }

        return sameCount;
    }

    private int compareForBonus(Winning target, Lotto lotto) {
        int bonusCount = 0;

        int bonusNumber = target.getBonusNumber();
        if (lotto.contains(bonusNumber)) {
            bonusCount++;
        }

        return bonusCount;
    }

}
