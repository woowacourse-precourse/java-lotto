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
            throw new IllegalArgumentException
                    ("[ERROR]: 보너스 번호는 반드시 1~45 이내에 숫자여야 합니다.");
        }
    }

    public void checkBonusDuplicatedNumber(int bonusNumber, List<Integer> lotto){
        if (lotto.contains(bonusNumber)){
            throw new IllegalArgumentException
                    ("[ERROR]: 보너스 번호는 입력한 당첨번호와 중복되어선 안됩니다.");
        }
    }

    private void isRealNumber (String inputBonusNumber) {
        for (char element: inputBonusNumber.toCharArray()) {
            if (element < 48 || element > 57) {
                throw new IllegalArgumentException
                        ("[ERROR]: 숫자만 입력할 수 있습니다.");
            }
        }
    }
}
