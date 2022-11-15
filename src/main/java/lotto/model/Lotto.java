package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i<numbers.size();i++){
            isDuplicated(numbers,numbers.get(i),i);
        }
    }

    public void isDuplicated(List<Integer> numbers, int number,int index) {
        for (int i = 0; i < numbers.size(); i++) {
            if(i==index){
                continue;
            }
            if (numbers.get(i) == number) {
                throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해주세요!");
            }
        }
    }

    public void printLotto(){
        System.out.print('[');
        for(int i =0;i<numbers.size()-1;i++){
            System.out.print(numbers.get(i));
            System.out.print(", ");
        }
        System.out.print(numbers.get(numbers.size()-1));
        System.out.println("]");
    }

    // TODO: 추가 기능 구현
}
