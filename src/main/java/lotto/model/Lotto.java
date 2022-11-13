package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String[] numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        List<Integer> lottos = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            try {
                int number = Integer.parseInt(numbers[i]);
                if(number <= 0 || number > 45){
                    throw  new IllegalArgumentException();
                }
                lottos.add(number);
            } catch (IllegalArgumentException e){
                throw  new IllegalArgumentException("[ERROR] 알맞은 숫자를 입력해주세요.");
            }
        }
        return lottos;
    }

}
