package lotto;

import static lotto.LottoPrize.FIFTH_PRIZE;
import static lotto.LottoPrize.FIRST_PRIZE;
import static lotto.LottoPrize.FOURTH_PRIZE;
import static lotto.LottoPrize.SECOND_PRIZE;
import static lotto.LottoPrize.SIXTH_PRIZE;
import static lotto.LottoPrize.THIRD_PRIZE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReferee {
    private final Map<LottoPrize, Integer> result = new HashMap<>();

    LottoReferee() {
        for (LottoPrize prize : List.of(SIXTH_PRIZE,FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)) {
            result.put(prize, 0);
        }
    }

    public int sumPrizes() {
        int wins = 0;
        for (LottoPrize prize : List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)) {
            wins += result.get(prize)*prize.ofPrize();
        }
        return wins;
    }

    public Map<LottoPrize, Integer> analyzeResult(LotteryMachine lotteryMachine, Buyer buyer) {
        for (Lotto buyerLotto : buyer.getHoldingLottoTickets()) {
            LottoPrize prize = checkWinPrize(lotteryMachine, buyerLotto);
            result.put(prize, result.get(prize) + 1);
        }
        return result;
    }

    private LottoPrize checkWinPrize(LotteryMachine lotteryMachine, Lotto buyerLotto) {
        Lotto winningLotto = lotteryMachine.getWinningLotto();
        int bonusNumber = lotteryMachine.getBonusNumber();

        LottoPrize lottoPrize = SIXTH_PRIZE;
        int sameCount = compare(winningLotto, buyerLotto);
        if (sameCount == 6) {
            lottoPrize = FIRST_PRIZE;
        }
        if (sameCount == 5) {
            lottoPrize = rankSecondOrThird(bonusNumber, buyerLotto);
        }
        if (sameCount == 4) {
            lottoPrize = FOURTH_PRIZE;
        }
        if (sameCount == 3) {
            lottoPrize = FIFTH_PRIZE;
        }
        return lottoPrize;
    }
    private int compare(Lotto winningLotto, Lotto buyerLotto) {
        int count=0;
        for(int i=0;i<6;i++){
            if(winningLotto.contains(buyerLotto.getNumbers().get(i))){
                count++;
            }
        }
        return count;
    }

    private LottoPrize rankSecondOrThird(int bonusNumber, Lotto buyerLotto) {
        if (buyerLotto.contains(bonusNumber)) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }


}
