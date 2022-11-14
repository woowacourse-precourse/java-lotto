package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try {
            validate(numbers);
            overlap(numbers);
            overcheck(numbers);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    // TODO: 추가 기능 구현
    // 당첨번호중 중복이 있을경우 예외처리
    private void overlap(List<Integer> numbers){
        Set<Integer> number = new HashSet<Integer>();
        int temp;
        for(int i =0; i < numbers.size();i++){
            temp = numbers.get(i);
            number.add(temp);
        }
        if (number.size() !=6 ) throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.");
    }

    private void overcheck(List<Integer> numbers){
        int temp;
        for(int i =0;i < numbers.size();i++){
            temp = numbers.get(i);
            if(temp>45 || temp <1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public float check_rank(List<Integer> lotto_nums){
        float check = 0;
        int num;
        List<Integer> numbers = this.numbers;
        for(int i=0;i<lotto_nums.size();i++){
            num = lotto_nums.get(i);
            if(numbers.contains(num)){
                check++;
            }
        }
        return check;
    }
    public void check_bonus(int bonus){
        if(numbers.contains(bonus)) throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨번호가 같을 수 없습니다");
    }

}
