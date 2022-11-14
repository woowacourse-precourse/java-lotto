package lotto;

import java.util.List;

public class BonusNumber {

    private final String bonusNumber;

    private final List<Integer> numbers;

    static Integer bonus;

    public BonusNumber(String bonusNumber, List<Integer> numbers){
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
        makeBonusNumber();
    }

    public int makeBonusNumber() {
        int bonusNum = Integer.parseInt(bonusNumber);
        if(numbers.contains(bonus)){
            new Exceptions("보너스 번호가 중복됩니다.");
        }
        bonus = bonusNum;
        return bonusNum;
    }
}
