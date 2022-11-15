package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {


    public List<LottoResult> calculateWins(List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber) {
        List<LottoResult> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(getGrade(winNumbers, bonusNumber, lotto.getNumbers()));
        }
        return result;
    }

    private LottoResult getGrade(List<Integer> winNumbers, int bonusNumber, List<Integer> numbers) {
        int count = 0;
        for (int number : numbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return getGradeResult(bonusNumber, numbers, count);
    }

    private LottoResult getGradeResult(int bonusNumber, List<Integer> numbers, int count) {
        if (count == 6) {
            return LottoResult.first;
        }
        if (count == 5 && numbers.contains(bonusNumber)) {
            return LottoResult.second;
        }
        if (count == 5 && !numbers.contains(bonusNumber)) {
            return LottoResult.third;
        }
        if (count == 4) {
            return LottoResult.fourth;
        }
        if (count == 3) {
            return LottoResult.fifth;
        }
        return LottoResult.none;
    }

    // 수익률 계산
    public String moneyCalculation(int money, int prize){
        return String.format("%.1f", (prize * 100.0 / money));
    }
}
