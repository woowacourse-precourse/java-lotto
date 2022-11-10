package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LotteryTicketingMachine {

    private int money;

    public int TicketHowManyLotto(int money) {
        int howManyLotto;
        howManyLotto = money/1000;
        return howManyLotto;
    }

    public Lotto TicketLotto() {
        Lotto lotto;
        lotto = new Lotto(pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }

}
