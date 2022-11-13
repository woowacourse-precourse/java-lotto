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
            int matchCount = resultMatchCount(comparedWinningNumber);
            if(matchCount == 5){
                result[compareBonusNumber(comparedWinningNumber, bonusNumber)]++;
            }
            if(matchCount >= 3){
                result[matchCount-3]++;
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
        return 4;
    }

    private static int resultMatchCount(List<Integer> comparedWinningNumber){
        int matchedCount = 6 - comparedWinningNumber.size();
        return matchedCount;
    }
}
