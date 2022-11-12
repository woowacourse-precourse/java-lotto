package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {
    public static int purchaseCount;

    public void priceInput() {
        System.out.println(LottoMessage.START_MESSAGE.getMessage());
        String purchaseAmount = Console.readLine();
        for(int index=0;index<purchaseAmount.length();index++) {
            if (!Character.isDigit(purchaseAmount.charAt(index))) {
                throw new IllegalArgumentException(LottoMessage.INTEGER_INPUT_ERROR_MESSAGE.getMessage());
            }
            Purchase userPurchase = new Purchase(Integer.parseInt(purchaseAmount));
            purchaseCount = userPurchase.calculateCount();
        }
    }
}
