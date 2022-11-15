package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.makeLotto;
import static lotto.domain.place.MatchResult.findByCondition;
import static lotto.validation.LottoNumberValidation.validateDuplicate;

import java.util.List;
import lotto.domain.place.MatchResult;

public class WinningLotto {

    protected final Lotto lotto;
    protected final BonusNum bonusNum;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        validate(lottoNumbers, bonusNumber);

        lotto = makeLotto(lottoNumbers);
        bonusNum = new BonusNum(bonusNumber);
    }

    public static WinningLotto makeWinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateDuplicate(numbers, bonusNumber);
    }

    public MatchResult makeMatchResult(Lotto purchaseLotto) {
        return findByCondition(purchaseLotto.makeCondition(lotto, bonusNum));
    }
}