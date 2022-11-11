package lotto.domain;

import static lotto.domain.LottoPrize.FIFTH_PRIZE;
import static lotto.domain.LottoPrize.FIRST_PRIZE;
import static lotto.domain.LottoPrize.FOURTH_PRIZE;
import static lotto.domain.LottoPrize.SECOND_PRIZE;
import static lotto.domain.LottoPrize.SIXTH_PRIZE;
import static lotto.domain.LottoPrize.THIRD_PRIZE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoReferee {
    private final Map<LottoPrize, Integer> result = new HashMap<>();

    public LottoReferee() {
        for (LottoPrize prize : List.of(SIXTH_PRIZE, FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE,
                FIRST_PRIZE)) {
            result.put(prize, 0);
        }
    }

    public int sumPrizes() {
        int prizes = 0;
        for (LottoPrize prize : List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)) {
            prizes += result.get(prize) * prize.ofPrize();
        }
        return prizes;
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
        int sameCount = compare(winningLotto, buyerLotto);
        if (sameCount == 6) {
            return FIRST_PRIZE;
        } else if (sameCount == 5) {
            return rankSecondOrThird(buyerLotto, bonusNumber);
        } else if (sameCount == 4) {
            return FOURTH_PRIZE;
        } else if (sameCount == 3) {
            return FIFTH_PRIZE;
        }
        return SIXTH_PRIZE;
    }

    private int compare(Lotto winningLotto, Lotto buyerLotto) {
        return buyerLotto.compare(winningLotto);
    }

    private LottoPrize rankSecondOrThird(Lotto buyerLotto, int bonusNumber) {
        if (buyerLotto.contains(bonusNumber)) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }


}
