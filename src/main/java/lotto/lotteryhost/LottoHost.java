package lotto.lotteryhost;

import java.util.ArrayList;
import java.util.List;

public class LottoHost {

    public List<Integer> matchNotContainBonusNumber(
            List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers) {

        List<Integer> MatchResultNotContainBonusNumber = new ArrayList<>();

        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += generatedLottoNumber.stream()
                        .filter(e -> e.equals(winningNumber))
                        .count();
            }
            MatchResultNotContainBonusNumber.add(count);
        }
        return MatchResultNotContainBonusNumber;
    }
    public List<Integer> matchContainBonusNumber(
            List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers, int bonusNumber) {
        List<Integer> MatchResultContainBonusNumber = new ArrayList<>();

        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += generatedLottoNumber.stream()
                        .filter(e -> e.equals(winningNumber))
                        .filter(e -> e.equals(bonusNumber))
                        .count();
            }
            MatchResultContainBonusNumber.add(count);
        }
        return MatchResultContainBonusNumber;
    }

}
