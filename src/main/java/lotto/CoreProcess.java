package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CoreProcess {

    ProcessData bring = new ProcessData();


    public List<Integer> setLottoNumber() {
        List<Integer> LottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(LottoNumber);
        return LottoNumber;
    }

    public int compareNumber(List<Integer> Lotto, List<Integer> pickedNumber) {
        List<Integer> overlapList = Lotto.stream()
                .filter(num -> pickedNumber.stream()
                        .anyMatch(Predicate.isEqual(num)))
                .collect(Collectors.toList());
        return overlapList.size();
    }

    public boolean checkBonus(List<Integer> Lotto, int bonus) {
        boolean check = false;
        for (int i = 0; i < Lotto.size(); i++) {
            if (Lotto.get(i) == bonus) {
                check = true;
            }
        }
        return check;
    }

    public winPrize checkSecond(boolean bonus) {
        if (bonus) {
            return winPrize.SECOND;
        }
        return null;
    }


    public winPrize setResult(int compareNumber, boolean bonus) {
        if (compareNumber == winPrize.SECOND.count) {
            return checkSecond(bonus);
        }
        for (winPrize value : winPrize.values()) {
            if (value.count == compareNumber) {
                return value;
            }
        }
        return null;
    }

}

