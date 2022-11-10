package lotto.insert;

import static lotto.insert.ExceptionFactory.amountException;

import java.util.List;

public class AutomaticDispenser extends Shell{

    private List<Integer> shell;
    private int LotteryTicket;

    public AutomaticDispenser(List<Integer> Shell) {

        super();

    }

    // 로또 발행 기능
    public int publishLotto() {

        LotteryTicket = shell.get(0) % 1000;

        if ( LotteryTicket / 1 < 0 ) {
            amountException();
        }

        return LotteryTicket;

    }

}
