package lotto;

import java.sql.Array;
import java.util.ArrayList;
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
        ArrayList<Integer> testNum = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if(testNum.indexOf(numbers.get(i))>0){
                throw new IllegalArgumentException();
            }
            testNum.add(numbers.get(i));
        }
    }

    public void printNumbers(){
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
