package lotto.application.service.lottomatcher;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcherImpl implements LottoMatcher {

    @Override
    public List<List<Integer>> matchWinningLotto(
            List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers, int bonusWinningNumber) {
        winningLottoNumbers.add(bonusWinningNumber);

        List<Integer> matchedWinningLotto = new ArrayList<>();
        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += generatedLottoNumber.stream()
                        .filter(e -> e.equals(winningNumber))
                        .count();
            }
            matchedWinningLotto.add(count);
        }

        List<Integer> countingContainBonusNumber = countContainBonusNumber(
                matchedWinningLotto, generatedLottoNumbers, bonusWinningNumber);

        return new ArrayList<>() {{
            add(matchedWinningLotto);
            add(countingContainBonusNumber);
        }};
    }

    @Override
    public List<Integer> countContainBonusNumber(
            List<Integer> matchedWinningLotto, List<List<Integer>> generatedLottoNumbers, int bonusWinningNumber) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < matchedWinningLotto.size(); index++) {
            if (matchedWinningLotto.get(index) == 5 &&
                    generatedLottoNumbers.get(index).contains(bonusWinningNumber)) {
                result.add(1);
            }
        }

        return result;
    }
}
