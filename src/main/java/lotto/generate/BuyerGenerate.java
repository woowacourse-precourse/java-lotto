package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.output.Output;

public class BuyerGenerate {

    private void digitValidate(String input) {
        char[] inputArray = input.toCharArray();
        for (char tmp : inputArray) {
            if (!Character.isDigit(tmp)) {
                throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다.");
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
