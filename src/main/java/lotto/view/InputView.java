package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.utils.Converter;

public class InputView {
    public static int inputPurchaseMoney() {
        return Converter.changeToMoney(readLine());
    }

    public static List<Integer> inputWinningNumber() {
        return Converter.changeToWinningNumber(readLine());
    }

    public static int inputBonusNumber() {
        return Converter.changeToBonusNumber(readLine());
    }
}