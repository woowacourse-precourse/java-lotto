package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPrice(){
        OutputView.askPrice();
        return Console.readLine();
    }

    public static String getWinNum(){
        OutputView.askWinNum();
        return Console.readLine();
    }

    public static String getBonusNum(){
        OutputView.askBonusNum();
        return Console.readLine();
    }
}
