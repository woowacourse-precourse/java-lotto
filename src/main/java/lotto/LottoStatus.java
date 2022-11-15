package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoStatus {

    public int[] countTheNumberOfWinning(int lottoCount, List<List<Integer>> lotto, List<Integer> winningNumber, Integer bonusNumber){
        int result[] = new int[5];
        for(int i=0; i<lottoCount; i++) {
            List<Integer> comparedWinningNumber = compareWinningNumber(lotto.get(i), winningNumber);
            int matchCountIndex = resultMatchCount(comparedWinningNumber, bonusNumber);
            if(matchCountIndex >= 0) {
                result[matchCountIndex]++;
            }
        }
        return result;
    }

    private static List<Integer> compareWinningNumber(List<Integer> lotto, List<Integer> winningNumber){
        List<Integer> resultList = winningNumber.stream()
                .filter(lottoNumber -> lotto.stream().noneMatch(Predicate.isEqual(lottoNumber)))
                .collect(Collectors.toList());
        return resultList;
    }

    private static int compareBonusNumber(List<Integer> comparedWinningNumber, Integer bonusNumber){
        if(comparedWinningNumber.contains(bonusNumber)){
            return 2;
        }
        return 3;
    }

    private static int resultMatchCount(List<Integer> comparedWinningNumber, Integer bonusNumber){
        int matchedCount = 6 - comparedWinningNumber.size();
        if(matchedCount == 5){
            return compareBonusNumber(comparedWinningNumber, bonusNumber);
        }
        if(matchedCount == 6){
            return 4;
        }
        return matchedCount-3;
    }
}
