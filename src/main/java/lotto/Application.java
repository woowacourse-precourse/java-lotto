package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private Integer getResult(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int result = 0;
        for (Integer number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                result += 1;
            }
        }
        return result;
    }

    private boolean getBonusNumberResult(Integer bonusNumber, Integer lottoBonusNumber) {
        return bonusNumber.equals(lottoBonusNumber);
    }
}
