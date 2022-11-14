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
        digitValidate(input);
        int buyPrice = Integer.parseInt(input);
        return new Buyer(buyPrice);
    }

    public void digitValidate(String input) {
        String inputValidate = input.replaceAll("[0-9]", "");
        if (inputValidate.length() > 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 유효하지 않습니다.");
        }
    }
}
