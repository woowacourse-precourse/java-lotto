package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LotteryTicketingMachine {

    public int ticketHowManyLotto(int money) {
        int howManyLotto;
        howManyLotto = money/1000;
        return howManyLotto;
    }

    public Lotto ticketLotto() {
        Lotto lotto;
        lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
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
