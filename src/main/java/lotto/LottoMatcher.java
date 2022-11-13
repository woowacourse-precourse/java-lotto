package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoMatcher(Lotto winningNumber, Integer bonusNumber) {
        this.winningNumbers = winningNumber.getNumbers();
        this.bonusNumber = bonusNumber;
    }

    public List<LottoGrade> matchAll(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::matchOne)
                .collect(Collectors.toList());
    }

    private LottoGrade matchOne(Lotto lotto) {
        int matchPoint = (int)winningNumbers.stream()
                .filter(lotto::isContain)
                .count();
        if(matchPoint == LottoGrade.SECOND.getMatchCount() &&
                lotto.isContain(bonusNumber)) {
            return LottoGrade.SECOND;
        }
        for(LottoGrade lottoGrade : LottoGrade.values()) {
            if(lottoGrade.getMatchCount() == matchPoint) {
                return lottoGrade;
            }
        }

        return LottoGrade.BANG;
    }
}
