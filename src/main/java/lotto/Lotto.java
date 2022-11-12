package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        overlap(numbers);
        overcheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    // 당첨번호중 중복이 있을경우 예외처리
    private void overlap(List<Integer> numbers){
        Set<Integer> number = new HashSet<Integer>();
        int temp;
        for(int i =0; i < numbers.size();i++){
            temp = numbers.get(0);
            number.add(temp);
        }
        if (number.size() !=0 ){
            System.out.println("[ERROR] 로또 번호는 중복 될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void overcheck(List<Integer> numbers){
        int temp;
        for(int i =0;i < numbers.size();i++){
            temp = numbers.get(i);
            if(temp>45 || temp <1) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

}
