package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleInput {
    public static int purchaseCount;
    public static List<Integer> luckySix;
    public static int bonusNumber;

    public void priceInput() {
        System.out.println(LottoMessage.START_MESSAGE.getMessage());
        String purchaseAmount = Console.readLine();
        for (int index = 0; index < purchaseAmount.length(); index++) {
            if (!Character.isDigit(purchaseAmount.charAt(index))) {
                throw new IllegalArgumentException(LottoMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
        }
        Purchase userPurchase = new Purchase(Integer.parseInt(purchaseAmount));
        purchaseCount = userPurchase.calculateCount();
    }

    public void luckySixInput() {
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
    }

    public void bonusInput() {
        System.out.println(LottoMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String inputBonus = Console.readLine();
        for (int index = 0; index < inputBonus.length(); index++) {
            if (!Character.isDigit(inputBonus.charAt(index))) {
                throw new IllegalArgumentException(LottoMessage.INTEGER_ERROR_MESSAGE.getMessage());
            }
            if (index == 1) {
                throw new IllegalArgumentException(LottoMessage.BONUS_ERROR_MESSAGE.getMessage());
            }
            bonusNumber = Character.getNumericValue(inputBonus.charAt(index));
        }
        LuckyAndBonus finalLuckyNumbers = new LuckyAndBonus(luckySix, bonusNumber);
    }
}
