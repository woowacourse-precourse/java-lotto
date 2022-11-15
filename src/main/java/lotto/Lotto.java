package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    /**
     * 3. validate ([ERROR] 예외발생 문구 출력) 보완중 <br/>
     * 1 ~ 45 이외의 숫자가 입력되면 에러발생 추가 <br/>
     * 숫자외에 글자가 입력되면 에러발생 추가
     * 
     * @param numbers
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 0) {
                throw new IllegalArgumentException("[ERROR] 입력값.에러 발생.");
            }
        }

        Set<Integer> numList = new HashSet<Integer>(numbers);
        if (numList.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복입력.에러 발생.");
        }
    }

}
