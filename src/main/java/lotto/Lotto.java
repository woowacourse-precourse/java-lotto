package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try{
            validate(numbers);
        }catch(IllegalArgumentException ex){
            throw new IllegalArgumentException(ex.getMessage());
        }
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (new HashSet<Integer>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 번호가 포함되면 안됩니다.");
        }
        rangecheck(numbers);
    }
    // TODO: 추가 기능 구현

    private void rangecheck(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void check_bonus(int bonus) {
        if(numbers.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨번호가 같을 수 없습니다");
    }
    public float check_rank(List<Integer> lotto_nums){
        float check = 0;
        List<Integer> numbers = this.numbers;
        for(Integer number : lotto_nums){
            if(numbers.contains(number)){
                check++;
            }
        }
        return check;
    }
}
