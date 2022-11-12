package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LuckyAndBonus {
    public List<Integer> luckySix;
    public int bonusNumber;

    public LuckyAndBonus(List<Integer> luckySix, int bonusNumber) {
        List<Integer> tempNumbers = new ArrayList<>(luckySix);
        tempNumbers.add(bonusNumber);
        if (tempNumbers.size() != tempNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LottoMessage.LUCKY_DUPLICATE_ERROR_MESSAGE.getMessage());
        }
        this.luckySix = luckySix;
        this.bonusNumber = bonusNumber;
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
