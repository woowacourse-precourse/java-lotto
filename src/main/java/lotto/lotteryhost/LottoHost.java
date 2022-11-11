package lotto.lotteryhost;

import java.util.ArrayList;
import java.util.List;

public class LottoHost {

    public List<Integer> match(List<List<Integer>> generatedLottoNumbers, List<Integer> winningLottoNumbers) {
        List<Integer> result = new ArrayList<>();

        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            int count = 0;
            for (Integer winningNumber : winningLottoNumbers) {
                count += generatedLottoNumber.stream()
                        .filter(e -> e.equals(winningNumber))
                        .count();
            }
            result.add(count);
        }
        return result;
    }
}
