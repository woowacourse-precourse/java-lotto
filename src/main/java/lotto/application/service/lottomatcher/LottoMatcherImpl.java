package lotto.application.service.lottomatcher;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcherImpl implements LottoMatcher {

    @Override
    public List<List<Integer>> matchWinningLotto(List<Lotto> generatedLottoNumbers, List<Integer> winningLottoNumbers) {
        List<Integer> matchedWinningLotto = new ArrayList<>();

        for (Lotto generatedLottoNumber : generatedLottoNumbers) {
            List<Integer> lotto = generatedLottoNumber.getNumbers();
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += lotto.stream()
                        .filter(e -> e.equals(winningNumber))
                        .count();
            }
            matchedWinningLotto.add(count);
        }

        List<Integer> countingContainBonusNumber = countContainBonusNumber(
                matchedWinningLotto, generatedLottoNumbers, winningLottoNumbers.get(winningLottoNumbers.size() - 1));

        return new ArrayList<>() {{
            add(matchedWinningLotto);
            add(countingContainBonusNumber);
        }};
    }

    @Override
    public List<Integer> countContainBonusNumber(
            List<Integer> matchedWinningLotto, List<Lotto> generatedLottoNumbers, int bonusWinningNumber) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < matchedWinningLotto.size(); index++) {
            if (matchedWinningLotto.get(index) == 5 &&
                    generatedLottoNumbers.get(index)
                            .getNumbers()
                            .contains(bonusWinningNumber)) {
                result.add(1);
            }
        }

        return result;
    }
}
