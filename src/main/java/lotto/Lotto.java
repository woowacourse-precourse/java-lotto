package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException{
        try{
            validate(numbers);
            this.numbers = numbers;
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6 || isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 로또 번호 추출");
        }
    }

    private boolean isDuplicate(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++){
            if (haveNumberInRange(numbers, numbers.get(i), i + 1, numbers.size())){
                return true;
            }
        }
        return false;
    }

    private boolean haveNumberInRange(List<Integer> numbers, int number, int start, int end){
        for (int i = start; i < end; i++){
            if (numbers.get(i) == number){
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
    // TODO: 추가 기능 구현
}
