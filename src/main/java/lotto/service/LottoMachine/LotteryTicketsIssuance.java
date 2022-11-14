package lotto.service.LottoMachine;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.validation.AmountValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTicketsIssuance extends IllegalArgumentException{
    private final static int COUNT_LOTTERY_NUMBER_NUMBERS = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private int amount;
    private List<List<Integer>> tickets;

    public LotteryTicketsIssuance(int amount) {
        try {
            if (AmountValidation.isValidAmount(amount)) {
                this.amount = amount;
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setTickets() {
        List<List<Integer>> issuedLotteryTickets = new ArrayList<List<Integer>>();
        int ticketsCount = amount / 1000;
        for (int i = 0; i < ticketsCount; i++) {
            List<Integer> newLottery = issueLotteryNumbers();
            issuedLotteryTickets.add(newLottery);
        }
        this.tickets = issuedLotteryTickets;
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }




    // 랜덤 숫자 배열 1개 뽑음
    private List<Integer> issueLotteryNumbers() {
        List<Integer> LotteryNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTERY_NUMBER_NUMBERS);
        Collections.sort(LotteryNumbers);

        return LotteryNumbers;
    }
}