package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.buyLotto;
import static lotto.Output.printLotto;
import static lotto.UserInput.*;

public class StartLotto {
    public static void startLotto() throws IllegalArgumentException{

        int money = moneyInput();
        List<Lotto> lotto = new ArrayList<>();
        buyLotto(money, lotto);
        printLotto(lotto);
        List<Integer> winNums = winNumInput();
        int bonusNum = bonusNumInput(winNums);
        List<Result> results = new ArrayList<>();
/*
        int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
        for (Result e : results) {
            if (e.getMatchCnt() == 6)
                first++;
            if (e.getMatchCnt() == 5)
                if (e.isBonusMatch())
                    second++;
                else third++;
            if (e.getMatchCnt() == 4)
                fourth++;
            if (e.getMatchCnt() == 3)
                fifth++;
            PrintEnd(first, second, third, fourth, fifth, money);
        }
        */

    }
}
