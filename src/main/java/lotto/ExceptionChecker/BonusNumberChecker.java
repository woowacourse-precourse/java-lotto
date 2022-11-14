package lotto.ExceptionChecker;

import java.util.NoSuchElementException;

public class BonusNumberChecker {

    private final int number;


    public BonusNumberChecker(int bonusNumber){
        validateRange(bonusNumber);

        this.number = bonusNumber;

    }

    public int bonusReturn(){
        return number;
    }

    public void validateRange(int winNumber) {
        try {
            if (winNumber > 45 || winNumber == 0) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 당첨 번호의 범위를 1~45사이에서 입력해주세요. ");
            IllegalArgumentException.printStackTrace();
            throw new NoSuchElementException();
        }
    }
}
