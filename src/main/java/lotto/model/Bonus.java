package lotto.model;

import lotto.message.PrintError;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(String inputBonusNumber, List<Integer> lotto){
        int number = convertNumber(inputBonusNumber);

        checkBonusNumberRange(number);
        checkBonusDuplicatedNumber(number, lotto);
        this.number = number;
    }

    public int getBonus () {
        return this.number;
    }

    public int convertNumber(String inputBonusNumber) {
        int number;

        isRealNumber(inputBonusNumber);
        number = Integer.parseInt(inputBonusNumber);

        return number;
    }

    public void checkBonusNumberRange(int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45){
            System.out.println(PrintError.BONUS_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public void checkBonusDuplicatedNumber(int bonusNumber, List<Integer> lotto){
        if (lotto.contains(bonusNumber)){
            System.out.println(PrintError.BONUS_OVERLAP);
            throw new IllegalArgumentException();
        }
    }

    private void isRealNumber (String inputBonusNumber) {
        for (char element: inputBonusNumber.toCharArray()) {
            if (element < 48 || element > 57) {
                System.out.println(PrintError.NUMBER_SIZE);
                throw new IllegalArgumentException();
            }
        }
    }
}
