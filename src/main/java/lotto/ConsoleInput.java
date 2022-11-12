package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleInput {
    public static int purchaseCount;
    public static List<Integer> luckySix;

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

    public void luckySixInput() {
        System.out.println(LottoMessage.LUCKY_NUMBER_MESSAGE.getMessage());
        String inputNumbers = Console.readLine();
        for(int index=0;index<inputNumbers.length();index++){
            char oneNumber = inputNumbers.charAt(index);
            if(oneNumber == ','){
                continue;
            }
            if (!Character.isDigit(oneNumber)) {
                throw new IllegalArgumentException(LottoMessage.INTEGER_INPUT_ERROR_MESSAGE.getMessage());
            }
            luckySix.add(Character.getNumericValue(oneNumber));
            Lotto luckyNumber = new Lotto(luckySix);
        }
    }
}
