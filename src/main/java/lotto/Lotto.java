package lotto;

import java.util.HashMap;
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

    public void inputBuyPirce(){
        System.out.println("구입금액을 입력해주세요");
    }

//    public HashMap<String, Integer>

    // TODO: 추가 기능 구현
}
