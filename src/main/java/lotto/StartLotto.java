package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.buyLotto;
import static lotto.Output.*;
import static lotto.UserInput.*;

public class StartLotto {
    public static void startLotto() throws IllegalArgumentException {
        int money = moneyInput();
        List<Lotto> lotto = new ArrayList<>();
        buyLotto(money, lotto);
        printLotto(lotto);
        List<Integer> winNums = winNumInput();
        int bonusNum = bonusNumInput(winNums);
        List<Check> checks = new ArrayList<>();
        checkSave(checks, winNums, lotto, bonusNum);
        //check 에 lotto 넣고 저장해야함
        Result result = new Result(checks);
        printEnd(result, money);
    }

    public static void checkSave(List<Check> checks, List<Integer> winNums, List<Lotto> lotto, int bonusNum) {
        for (Lotto e : lotto)
            checks.add(new Check(e, winNums, bonusNum));
    }
}
