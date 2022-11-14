package lotto;

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

    // TODO: 추가 기능 구현
    public void Print(){
        System.out.print("[");
        for(int i=0;i<numbers.size()-1;i++){
            System.out.print(numbers.get(i));
            System.out.print(", ");
        }
        System.out.print(numbers.get(numbers.size()-1));
        System.out.println("]");
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
