package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import constants.LottoConstants;

import java.util.List;

public class Computer {

    private List<Integer> lotteryNumbers;

    public List<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public void generateLotteryNumbers() {
        lotteryNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_LOTTO_VALUE,
                LottoConstants.MAX_LOTTO_VALUE,
                LottoConstants.LOTTO_NUM);
    }
}
