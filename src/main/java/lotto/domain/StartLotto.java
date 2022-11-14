package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.buyLotto;
import static lotto.IO.Output.*;
import static lotto.IO.UserInput.*;
import static lotto.domain.WinCheck.checkSave;

public class StartLotto {
    public static int payment;
    public static int bonusNum;
    public static List<Lotto> lotto;
    public static List<Integer> winNums;
    public static List<WinCheck> winChecks;
    public static Result result;

    public static void startLotto() throws IllegalArgumentException {
        paymentInput();
        lotto = new ArrayList<>();
        buyLotto();
        printLotto();
        winNumInput();
        bonusNumInput();
        winChecks = new ArrayList<>();
        checkSave();
        result = new Result();
        printResult();
    }
}
