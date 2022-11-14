package Character;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicketingMachine {

    public int ticketHowManyLotto (int money) throws IllegalArgumentException {
        int howManyLotto;

        if (money%1000!=0) {
            System.out.println("[ERROR] 입력 값은 1000으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
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
