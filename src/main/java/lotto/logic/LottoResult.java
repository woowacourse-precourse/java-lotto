package lotto.logic;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;

public class LottoResult {

    public LottoResult() {

    }

    public Map<Winning, Integer> getResult(WinningLotto target, List<Lotto> lottos) {
        Map<Winning, Integer> countOfWinning = new EnumMap<>(Winning.class);

        lottos.forEach(lotto -> {
            Optional<Winning> optionalWinning = getWinning(target, lotto);

            if (optionalWinning.isPresent()) {
                Winning winning = optionalWinning.get();
                int winngingCount = countOfWinning.getOrDefault(winning, 0) + 1;
                countOfWinning.put(winning, winngingCount);
            }
        });

        return countOfWinning;
    }

    private Optional<Winning> getWinning(WinningLotto target, Lotto lotto) {
        int sameCount = compareForSame(target, lotto);
        int bonusCount = compareForBonus(target, lotto);

        return Winning.getWinning(sameCount, bonusCount);
    }

    private int compareForSame(WinningLotto target, Lotto lotto) {
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

    private int compareForBonus(WinningLotto target, Lotto lotto) {
        int bonusCount = 0;

        int bonusNumber = target.getBonusNumber();
        if (lotto.contains(bonusNumber)) {
            bonusCount++;
        }

        return bonusCount;
    }

}
