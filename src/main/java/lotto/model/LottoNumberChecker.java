package lotto.model;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberChecker {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;
    private final List<Lotto> lottos;

    public LottoNumberChecker(Lotto winningLotto, LottoNumber bonusNumber, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    public MatchResult resultOfLotteries() {
        return new MatchResult(saveNumberOfWinner());
    }

    private EnumMap<MatchType, Integer> saveNumberOfWinner() {
        return lottos.stream()
                .map(this::countMatchedLottoNumber)
                .filter(numberMatched -> numberMatched >= MatchType.THREE.getNumberMatched())
                .collect(Collectors.toMap(
                        MatchType::fromNumberMatched, x -> 1, Integer::sum, () -> {
                            EnumMap<MatchType, Integer> em = new EnumMap<>(MatchType.class);
                            EnumSet.allOf(MatchType.class).forEach(c -> em.put(c, 0));
                            return em;
                        }));
    }

    private double countMatchedLottoNumber(Lotto lotto) {
        int matchedNumber = (int) lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
        if (hasBonusNumberWhenFiveNumberMatched(lotto, matchedNumber)) {
            return MatchType.FIVE_BONUS.getNumberMatched();
        }
        return matchedNumber;
    }

    private boolean hasBonusNumberWhenFiveNumberMatched(Lotto lotto, int matchedNumber) {
        return matchedNumber == MatchType.FIVE.getNumberMatched() && lotto.getNumbers().contains(bonusNumber);
    }
}
