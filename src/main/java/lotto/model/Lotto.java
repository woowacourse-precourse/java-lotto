package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer>  numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        List<Integer> lottos = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            int number = numbers.get(i);
            if(number <= 0 || number > 45){
                throw new IllegalArgumentException("[ERROR] 알맞은 범위의 숫자를 입력해주세요.");
            }
            if(lottos.contains(number)){
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
            }
            lottos.add(number);
        }
        return lottos;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
