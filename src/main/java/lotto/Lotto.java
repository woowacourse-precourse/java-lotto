package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 번호가 6자리가 아닙니다.");
        }
        if (duplicateCheck(numbers)) {
            throw new IllegalArgumentException("[ERROR] 입력한 번호 중 중복하는 번호가 있습니다.");
        }
        if (limitCheck(numbers)) {
            throw new IllegalArgumentException("[ERROR] 입력한 번호 중 1~45 범위를 벗어나는 번호가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    private boolean duplicateCheck(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(tempNumbers.contains(numbers.get(i))) {
                return true;
            }
            tempNumbers.add(numbers.get(i));
        }
        return false;
    }
    private boolean limitCheck(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > 45 || numbers.get(i) < 1) {
                return true;
            }
        }
        return false;
    }



    }



}
