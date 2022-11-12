package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleInput {
    public static int buyLotto() {
        System.out.println(GameMessage.PRICE_MESSAGE.getMessage());
        String payPrice = Console.readLine();
        Purchase purchaseLotto = new Purchase(payPrice);
        return purchaseLotto.calculateCount();
    }

    /*public static void luckySixInput() {
        System.out.println(LottoMessage.LUCKY_NUMBER_MESSAGE.getMessage());
        String inputNumbers = Console.readLine();
        for (int index = 0; index < inputNumbers.length(); index++) {
            char oneNumber = inputNumbers.charAt(index);
            if (oneNumber == ',') {
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException(LottoMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
            luckySix.add(Character.getNumericValue(oneNumber));
        }
    }*/

}
