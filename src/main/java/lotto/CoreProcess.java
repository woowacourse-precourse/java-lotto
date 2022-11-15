package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.*;

public class CoreProcess {

    ProcessData bring = new ProcessData();


    public List<Integer> setLottoNumber() {
        List<Integer> LottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(LottoNumber);
        return LottoNumber;
    }

    public List<List<Integer>> lottoPack(int moneyChance){
        List<List<Integer>> lottoPack = new ArrayList<>();
        for (int i = 0; i < moneyChance; i++) {
            List<Integer> setLottoNumber = setLottoNumber();
            lottoPack.add(setLottoNumber);
        }
        return lottoPack;
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

    public winPrize setResult(int compareNumber, boolean checkBonus) {
        if (compareNumber == winPrize.SECOND.count && checkBonus) {
            return winPrize.SECOND;
        }
        if (compareNumber < winPrize.FIFTH.count) {
            return winPrize.MISS;
        }
        return Arrays.stream(winPrize.values()).filter(winPrize -> winPrize.count == compareNumber)
                .findAny().orElseThrow();
    }

    public int earningRatio(int moneyChance, int earning) {
        return (earning * 100 / (moneyChance * 1000));

    }

}


