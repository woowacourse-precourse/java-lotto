package lotto.service.executeLotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTicketsIssuance {
    private final static int COUNT_LOTTERY_NUMBER_NUMBERS = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private int amount;

    public LotteryTicketsIssuance(int amount) {
        this.amount = amount;
    }

    public List<List<Integer>> getLotteries() {
        List<List<Integer>> issuedLotteryTickets = new ArrayList<List<Integer>>();
        while (amount != 0) {
            List<Integer> newLottery = issueLotteryNumbers();
            issuedLotteryTickets.add(newLottery);
            amount = amount - 1000;
        }
        return issuedLotteryTickets;
    }

    // 랜덤 숫자 배열 1개 뽑음
    private List<Integer> issueLotteryNumbers() {
        List<Integer> LotteryNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTERY_NUMBER_NUMBERS);
        Collections.sort(LotteryNumbers);
        
        return LotteryNumbers;
    }
}