package lotto;

import java.util.List;

public class BonusNumber {

    public final Integer bonusNumber;

    private final List<Integer> numbers;

    static Integer bonus;
    static String ERROR_MESSAGE = "[ERROR]";
    public BonusNumber(Integer bonusNumber, List<Integer> numbers){
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
        checkBonusNumber();
    }

    public void checkBonusNumber() {
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
           // new Exceptions("[ERROR] 보너스 번호가 중복됩니다.");
        }
        checkTheRange();
    }

    private void checkTheRange() {
        if(bonusNumber>45){
            throw new IllegalArgumentException(ERROR_MESSAGE);
            //new Exceptions("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
