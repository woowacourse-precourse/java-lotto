package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.enums.StringEnum;

import static lotto.enums.StringEnum.*;

public class BuyerGenerate {
    public void askBuyPricePrint() {
        System.out.println(PRICE.getMessage());
    }

    public Buyer generate() {
        askBuyPricePrint();
        String input = Console.readLine();
        int buyPrice = Integer.parseInt(input);
        return new Buyer(buyPrice);
    }
}
