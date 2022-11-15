package lotto.domain.lotto;

import static lotto.validation.LottoNumberValidation.validateDuplicate;

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

    public MatchResult makeMatchResult(Lotto purchaseLotto) {
        return MatchResult.findByCondition(makeCondition(purchaseLotto));
    }

    private PlaceCondition makeCondition(Lotto purchaseLotto) {
        return PlaceCondition.findByCondition(purchaseLotto.matchCount(lotto), purchaseLotto.isBonusNumMatch(bonusNum));
    }
}