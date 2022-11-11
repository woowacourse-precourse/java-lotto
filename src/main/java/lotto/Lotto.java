package lotto;

import java.util.List;

public class Lotto {  
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { // 사용자 입력 숫자 6개를 받아서 numbers 인스턴스 final 변수에 저장
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumbers() {
    	return numbers;
    }
    
    public void numbersNoRepeat() {
    	
    }
}
