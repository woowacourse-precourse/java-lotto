package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6){
            String message = "로또 번호는 총 6개의 숫자이여야 합니다.";
            throwLottoException(message);
        }
        validateDuplicate(numbers);
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public void validateDuplicate(List<Integer> numbers){
        String msg = "로또 번호 사이에는 중복이 없어야 합니다.";
        for(int elem : numbers) {
            if(numbers.indexOf(elem) != numbers.lastIndexOf(elem)) throwLottoException(msg);
        }
    }

    public void throwLottoException(String message){
        throw new IllegalArgumentException("[ERROR] " + message);
    }
}
