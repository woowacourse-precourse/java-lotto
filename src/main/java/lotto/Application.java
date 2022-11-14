package lotto;

/* lotto class를 사용해 구현 */
/* java enum을 사용할 것 */
/* else를 쓰지말 것. */

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    // 로또 자동번호 생성
    public List<HashSet<Integer>> createAutoNumbers(int numberOfPurchases) {
        List<HashSet<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPurchases; i++) {
            lottoNumbers.add((HashSet<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lottoNumbers.get(lottoNumbers.size() - 1));
        }
        return lottoNumbers;
    }

    // 보너스 번호 포함 당첨번호 생성
    private HashSet winningNumber(int bonusNumber, List<Integer> lottoNumbers){
        HashSet<Integer> winningNumbers = new HashSet<>(lottoNumbers);
        winningNumbers.add(bonusNumber);
        return winningNumbers;
    }

    // 당첨 통계 생성
    public int[] lottoStatistics(int bonusNumber, List<HashSet<Integer>> lottoNumbers){
        int[] statistics = new int[6];
        HashSet winningNumbers = winningNumber(bonusNumber);
        validateNumberRange(winningNumbers);
        for(HashSet autoLotto: lottoNumbers){
            autoLotto.retainAll(winningNumbers);
            if (autoLotto.size() >= 3){
                statistics[autoLotto.size()] += 1;
            }
        }
        return statistics;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
