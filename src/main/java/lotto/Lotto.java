package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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

    public List<Integer> getLotto(){
        return numbers;
    }

    public String getString(){
        String result = "[";
        for(int i=0; i<6; i++){
            result += numbers.get(i);
            if(i!=5) result += ", ";
        }
        result += "]";
        return result;
    }

    // TODO: 추가 기능 구현
}
