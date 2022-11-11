package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {  
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { // 사용자 입력 숫자 6개를 받아서 numbers 인스턴스 final 변수에 저장
        validate(numbers);
        numbersNoRepeat(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {  //숫자의 개수 6개인지 확인하기
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자의 개수가 6개가 아닙니다.");
        }
    }

    public void numbersNoRepeat(List<Integer> numbers) {  //숫자가 중복되는지 확인하기
    	HashSet<Integer> numbersset = new HashSet<>();
    	numbersset.addAll(numbers);
    	
    	if (numbersset.size() != 6) {
    		throw new IllegalArgumentException("[ERROR] 서로 다른 숫자 6개를 입력하세요.");
    	}
    }
    
    public List<Integer> getLottoNumbers() {
    	return numbers;
    }
    
}
