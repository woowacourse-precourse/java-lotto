package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumbers(){

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<numbers.size()-1;i++){
            sb.append(numbers.get(i)+",");
        }
        sb.append(numbers.get(numbers.size()-1));
        return sb.toString();

    }


    // TODO: 추가 기능 구현
}
