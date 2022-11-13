package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 번호가 6자리가 아닙니다.");
        } else if (duplicateCheck(numbers)) {
            throw new IllegalArgumentException("[ERROR] 입력한 번호 중 중복하는 번호가 있습니다.");
        }
    }

    private boolean duplicateCheck(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(tempNumbers.contains(numbers.get(i))) {
                tempNumbers.add(numbers.get(i));
            } else {
                return true;
            }
        }
        return false;
    }



    // TODO: 추가 기능 구현
}
