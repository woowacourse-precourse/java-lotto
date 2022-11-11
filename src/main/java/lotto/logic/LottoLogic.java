package lotto.logic;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Win;

import java.util.Arrays;
import java.util.List;

public class LottoLogic {

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    /**
     * 하나의 배열에 로또 번호, 당첨 번호가 등장하면
     * 해당 인덱스의 값을 1증가시킨다.
     * 값이 2라는 것은 해당 인덱스의 번호가 일치하는 것이다.
     * @param lottoNumbers
     * @param winningNumbers
     * @param bonusNumber
     * @return
     */
    public Result compareNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        int[] numbers = new int[46];
        lottoNumbers.forEach(number -> numbers[number]++);
        winningNumbers.forEach(number -> numbers[number]++);

        return new Result((int) Arrays.stream(numbers).filter(numberCount -> numberCount == 2).count(),
                lottoNumbers.contains(bonusNumber));
    }

    public Integer getPrize(Result result) {
        return Win.getPRIZE(result.getMatchCount(), result.isMatchBonus());
    }

    public void addWinCount(Result result) {
        Win.increaseCount(result.getMatchCount(), result.isMatchBonus());
    }

    public List<Integer> getHistory() {
        return Win.getCountTable();
    }
}
