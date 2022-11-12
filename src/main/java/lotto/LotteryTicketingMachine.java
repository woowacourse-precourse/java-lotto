package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LotteryTicketingMachine {

    public int ticketHowManyLotto(int money) {
        int howManyLotto;
        howManyLotto = money/1000;
        return howManyLotto;
    }

    public Lotto ticketLotto() {
        ArrayList<Integer> willBeLotto;
        willBeLotto = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        Lotto lotto = new Lotto(willBeLotto);
        lotto.sort();
        return lotto;
    }

    public int checkWinningNumber(List<Integer> winningNumber, Lotto lotto) {
        int howManyWinningNumber = 0;
        for (int winningNumberContent : winningNumber) {
            if (lotto.contains(winningNumberContent)) {
                howManyWinningNumber++;
            }
        }
        return howManyWinningNumber;
    }
}
