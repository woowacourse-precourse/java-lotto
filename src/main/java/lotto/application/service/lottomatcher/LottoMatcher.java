package lotto.application.service.lottomatcher;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoMatcher {

    List<List<Integer>> matchWinningLotto(List<Lotto> generatedLottoNumbers, List<Integer> winningLottoNumbers);


    List<Integer> countContainBonusNumber(List<Integer> matchedWinningLotto, List<Lotto> generatedLottoNumbers,
                                          int bonusWinningNumber);
}
