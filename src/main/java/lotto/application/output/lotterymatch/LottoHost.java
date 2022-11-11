package lotto.application.output.lotterymatch;

import java.util.ArrayList;
import java.util.List;

public class LottoHost {

    public List<List<Integer>> matchNotContainBonusNumber(
            List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers, int bonusWinningNumber) {

        winningLottoNumbers.add(bonusWinningNumber);
        List<Integer> matchResultNotContainBonusNumber = new ArrayList<>();
        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += generatedLottoNumber.stream()
                        .filter(e -> e.equals(winningNumber))
                        .count();
            }
            matchResultNotContainBonusNumber.add(count);
        }

        List<Integer> countingContainBonusNumber = countContainBonusNumber(
                matchResultNotContainBonusNumber, generatedLottoNumbers, bonusWinningNumber);
        return new ArrayList<>() {{
            add(matchResultNotContainBonusNumber);
            add(countingContainBonusNumber);
        }};
    }

    public List<Integer> countContainBonusNumber(
            List<Integer> matchResultNotContainBonusNumber,
            List<List<Integer>> generatedLottoNumbers, int bonusWinningNumber) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matchResultNotContainBonusNumber.size(); i++) {
            if (matchResultNotContainBonusNumber.get(i) == 5 &&
                    generatedLottoNumbers.get(i).contains(bonusWinningNumber)) {
                result.add(1);
            }
        }
        return result;
    }
}
