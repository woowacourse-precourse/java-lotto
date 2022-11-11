package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    public boolean contains(int number){
        return numbers.contains(number);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
        if(!validateRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if(!validateDuplicates(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }

    }
    private boolean validateRange(List<Integer> numbers){
        for(int number : numbers){
            if(number<1 || number>45){
                return false;
            }
        }
        return true;
    }
    private boolean validateDuplicates(List<Integer> numbers){
        Set<Integer> notDuplicated=new HashSet<>(numbers);
        return notDuplicated.size()==6;
    }
}
