package lotto.application.output.lotterymatch;

import java.util.ArrayList;
import java.util.List;

public class LottoHost {

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

    public List<Integer> countContainBonusNumber(
            List<Integer> matchedWinningLotto, List<List<Integer>> generatedLottoNumbers, int bonusWinningNumber) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matchedWinningLotto.size(); i++) {
            if (matchedWinningLotto.get(i) == 5 &&
                    generatedLottoNumbers.get(i).contains(bonusWinningNumber)) {
                result.add(1);
            }
        }
        return result;
    }
}
