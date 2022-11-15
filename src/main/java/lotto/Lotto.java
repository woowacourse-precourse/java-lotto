package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개가 넘는 숫자를 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
        for (int i=0; i < 6; i++){
            int number = numbers.get(i);
            if (1 > number && number > 45){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
            if (numbers.size() != numbers.stream().distinct().count()){
                System.out.println("[ERROR] 로또 번호에 동일한 숫자를 입력할 수 없습니다.");
                throw new IllegalArgumentException();
            }
        }

    }

    public void sort(){
        Collections.sort(this.numbers);
    }

    public void print_lotto(){
        System.out.println(this.numbers);
    }

    public List<Integer> return_lotto(){
        return this.numbers;
    }


    public int get_lotto_number(int i){
        return this.numbers.get(i);
    }

    // TODO: 추가 기능 구현
}
