package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateTwo(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers(){
        return this.numbers;
    }
    public void validateTwo(List<Integer> numbers){
        List<Integer> num = new ArrayList<>();
        for(int i= 1; i< numbers.size(); i++){
            if(num.contains(numbers.get(i))){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
            num.add(numbers.get(i));
        }
    }
}
