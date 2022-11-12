package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.output.Output;

public class BuyerGenerate {

    private void digitValidate(String input) {
        char[] inputArray = input.toCharArray();
        for (char tmp : inputArray) {
            if (!Character.isDigit(tmp)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Buyer generate() {
        Output.askBuyPrice();
        String input = Console.readLine();
        digitValidate(input);
        int buyPrice = Integer.parseInt(input);
        return new Buyer(buyPrice);
    }
}
