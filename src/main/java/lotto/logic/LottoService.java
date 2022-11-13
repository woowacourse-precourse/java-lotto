package lotto.logic;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningInfo;

public class LottoService {

    private static class LottoServiceHolder {
        private static final LottoService INSTANCE = new LottoService();
    }

    private LottoService() {

    }

    public static LottoService getInstance() {
        return LottoServiceHolder.INSTANCE;
    }

    public Map<Rank, Integer> getResult(List<Lotto> lottos, WinningInfo target) {
        Map<Rank, Integer> countOfWinning = new EnumMap<>(Rank.class);

        lottos.forEach(lotto -> {
            Optional<Rank> optionalWinning = getWinning(target, lotto);

            if (optionalWinning.isPresent()) {
                Rank rank = optionalWinning.get();
                int winngingCount = countOfWinning.getOrDefault(rank, 0) + 1;
                countOfWinning.put(rank, winngingCount);
            }
        });

        return countOfWinning;
    }

    private Optional<Rank> getWinning(WinningInfo target, Lotto lotto) {
        int sameCount = compareForSame(target, lotto);
        int bonusCount = compareForBonus(target, lotto);
        return Rank.getWinning(sameCount, bonusCount);
    }

    private int compareForSame(WinningInfo target, Lotto lotto) {
        int sameCount = 0;

        Iterator<Integer> lottoNumbers = lotto.createIterator();
        while (lottoNumbers.hasNext()) {
            int number = lottoNumbers.next();

            if (target.contains(number)) {
                sameCount++;
            }
        }

        return sameCount;
    }

    private int compareForBonus(WinningInfo target, Lotto lotto) {
        int bonusCount = 0;

        int bonusNumber = target.getBonusNumber();
        if (lotto.contains(bonusNumber)) {
            bonusCount++;
        }

        return bonusCount;
    }

}
