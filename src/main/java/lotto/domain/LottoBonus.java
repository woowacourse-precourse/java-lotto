package lotto.domain;

import java.util.List;

public class LottoBonus {
    private final int bonus;
    private final List<Integer> numbers;

    public LottoBonus(List<Integer> numbers, int bonus) {
        validate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int getBonus(){
        return bonus;
    }

    private void validate(List<Integer> numbers, int bonus) {
        duplicate(numbers, bonus);
        notInclude(bonus);
    }

    private void duplicate(List<Integer> numbers, int bonus){
        if (numbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되면 안됩니다.");
        }
    }

    private void notInclude(int bonus){
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다.");
        }
    }
}
