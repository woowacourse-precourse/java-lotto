package lotto.model;

import lotto.message.PrintError;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(String inputBonusNumber, List<Integer> lotto){
        int number = convertNumber(inputBonusNumber);

        validateBonusNumberRange(number);
        checkBonusDuplicatedNumber(number, lotto);
        this.number = number;
    }

    public int getBonus () {
        return this.number;
    }

    // 입력된 문자열을 숫자로 변환하는 메서드
    public int convertNumber(String inputBonusNumber) {
        int number;

        isRealNumber(inputBonusNumber);
        number = Integer.parseInt(inputBonusNumber);

        return number;
    }

    // 입력된 보너스 번호가 1~45 이내인지 확인
    public void validateBonusNumberRange(int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45){
            PrintError.BONUS_RANGE.print();
            throw new IllegalArgumentException();
        }
    }

    // 입력된 보너스 번호가 입력한 로또 번호와 중복되는지 확인
    public void checkBonusDuplicatedNumber(int bonusNumber, List<Integer> lotto){
        if (lotto.contains(bonusNumber)){
            PrintError.BONUS_OVERLAP.print();
            throw new IllegalArgumentException();
        }
    }

    // 입력한 문자열이 숫자로만 이루어져있는지 확인
    private void isRealNumber (String inputBonusNumber) {
        for (char element: inputBonusNumber.toCharArray()) {
            if (element < 48 || element > 57) {
                PrintError.NUMBER_SIZE.print();
                throw new IllegalArgumentException();
            }
        }
    }
}
