package lotto.view;

import static lotto.util.InputUtil.toIntStringNumberParser;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputBuyingPrice() {
        String buyingPrice = Console.readLine();
        return toIntStringNumberParser(buyingPrice);
    }
}
