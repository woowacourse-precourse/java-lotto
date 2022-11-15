package controller;

import static model.WinStatistics.earningRate;

import camp.nextstep.edu.missionutils.Console;

import model.Lotto;
import java.util.List;
import view.Message;
import model.IsValid;
import model.WinStatistics;

public class StartLotto {
    public static int lottoQuantity;
    public static int bonusNumber;
    public static Lotto winNumber;
    public static List<Lotto> lottos;

    public static void startLotto() {
        try {
            getLotto();
            getWinNumber();
            getBonusNumber();
            WinStatistics.checkMatchNumber();
            earningRate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static void getLotto() {
        String money = getInput();
        Message.print(Message.INPUT_PURCHASE_MONEY);
        Message.printUserInput(money);

        IsValid.correctNumber(money);
        IsValid.moneyUnit(Integer.parseInt(money));
        Lotto.lottoQuantity(Integer.parseInt(money));
        lottos = Lotto.getLotto(lottoQuantity);
    }

    private static void getWinNumber() {
        String winNumber = getInput();
        Message.print(Message.INPUT_WIN_NUMBER);
        Message.printUserInput(winNumber);
        WinStatistics.setWinNumber(winNumber);
    }

    private static void getBonusNumber() {
        String bonusNumber = getInput();
        Message.print(Message.INPUT_BONUS_NUMBER);
        Message.printUserInput(bonusNumber);
        IsValid.bonusNumber(Integer.parseInt(bonusNumber));
        StartLotto.bonusNumber = Integer.parseInt(bonusNumber);
    }
}
