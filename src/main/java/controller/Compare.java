package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Compare {

    public static List<Integer> getIntegratedWinningNumber(List<Integer> winningNumber, List<Integer> bonusNumber) {
        List<Integer> integratedWinningNumber = new ArrayList<>();
        integratedWinningNumber.addAll(winningNumber);
        integratedWinningNumber.addAll(bonusNumber);
        if (!isDuplicate(integratedWinningNumber)) {
            return integratedWinningNumber;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

    static boolean isDuplicate(List<Integer> integratedWinningNumber) throws IllegalArgumentException {
        Set<Integer> duplicationCheck = new HashSet<>(integratedWinningNumber);
        if (duplicationCheck.size() == integratedWinningNumber.size()) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호 내 중복이 있습니다.");
    }

    public static int compareWithWinningNumber(List<Integer> winningNumber, List<Integer> lottoNumber) {
        int hitCount = 0;
        for (int lottoNum : lottoNumber) {
            if (winningNumber.contains(lottoNum)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    public static int compareWithBonusNumber(List<Integer> bonusNumber, List<Integer> lottoNumber) {
        int hitCount = 0;
        if (lottoNumber.contains(bonusNumber.get(0))) {
            hitCount++;
        }
        return hitCount;
    }
}
