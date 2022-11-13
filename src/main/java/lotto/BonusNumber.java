package lotto;

import java.util.List;

public class BonusNumber {

    private final String bonusNumber;

    private final List<Integer> numbers;

    public BonusNumber(String bonusNumber, List<Integer> numbers){
        this.bonusNumber = bonusNumber;
        this.numbers = numbers;
        makeBonusNumber();
    }

    public int makeBonusNumber() {
        int bonus = Integer.parseInt(bonusNumber);
        if(numbers.contains(bonus)){
            new Exceptions("보너스 번호가 중복됩니다.");
        }
        return bonus;
    }
}
