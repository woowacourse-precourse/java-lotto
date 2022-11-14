package lotto.domain.lotto;

import java.util.List;
import lotto.domain.place.MatchResult;
import lotto.domain.place.PlaceCondition;

public class WinningLotto {

    protected final Lotto lotto;
    protected final BonusNum bonusNum;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        validate(lottoNumbers, bonusNumber);

        lotto = new Lotto(lottoNumbers);
        bonusNum = new BonusNum(bonusNumber);
    }

    public static WinningLotto makeWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateDuplicate(numbers, bonusNumber);
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자와 중복이 되는 숫자가 존재합니다.");
        }
    }

    public MatchResult makeMatchResult(Lotto purchaseLotto) {
        return MatchResult.findByCondition(makeCondition(purchaseLotto));
    }

    private PlaceCondition makeCondition(Lotto purchaseLotto) {
        return PlaceCondition.findByCondition(purchaseLotto.matchCount(lotto), purchaseLotto.isBonusNumMatch(bonusNum));
    }
}