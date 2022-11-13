package lotto.application.service.lottomatcher;

import java.util.List;

public interface LottoMatcher {

    List<List<Integer>> matchWinningLotto(
            List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers, int bonusWinningNumber);


    List<Integer> countContainBonusNumber(
            List<Integer> matchedWinningLotto, List<List<Integer>> generatedLottoNumbers, int bonusWinningNumber);
}
