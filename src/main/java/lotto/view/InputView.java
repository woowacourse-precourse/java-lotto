package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.domain.Converter;

public class InputView {
    public static int inputPurchaseMoney() {
        int money = Converter.changeToMoney(readLine());
        return money;
    }
}
