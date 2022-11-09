package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.List;

public class WinningLottoNumbers {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int SIZE = 6;

    private List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);


    Lotto lotto = new Lotto(winningNumbers);

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return lotto.getBonusNumber();
    }
}
