package lotto.model;

import java.util.List;
import lotto.util.LottoExceptionMessage;

public class LottoCompany {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public LottoCompany(Lotto winningLotto, LottoNumber bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoExceptionMessage.WINNING_LOTTO_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

    public MatchResult showResultOfCustomerLotteries(List<Lotto> lotteries) {
        LottoNumberChecker lottoNumberChecker = new LottoNumberChecker(winningLotto, bonusNumber, lotteries);
        return lottoNumberChecker.resultOfLotteries();
    }
}
