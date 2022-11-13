package lotto.service.executeLotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LotteryNumbersIssuance {
    private final static int COUNT_LOTTERY_NUMBER_NUMBERS = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;


    public List<Integer> issueLotteryNumbers() {
        List<Integer> LotteryNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTERY_NUMBER_NUMBERS);
        // TODO: Validation 로직 추가하기 (유틸 툴 오류날 경우 대비)
        return LotteryNumbers;
    }

}