package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final String ERROR_NUMBER_OUT_OF_BOUND = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println(ERROR_NUMBER_OUT_OF_BOUND);
            }
        }
    }

    public List<Integer> getLotto(){
        List<Integer> lotto = new ArrayList<>();
        for(Integer number : numbers){
            lotto.add(number);
        }
        return lotto;
    }
}
