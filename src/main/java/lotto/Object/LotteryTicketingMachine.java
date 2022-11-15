package lotto.Object;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.Exception.Exception;

public class LotteryTicketingMachine {

    Exception exception = new Exception();

    public int ticketHowManyLotto (int money) throws IllegalArgumentException {
        int howManyLotto;

        if (money%1000!=0||money<0) {
           exception.throwInvalidNumberRangeException();
        }

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
