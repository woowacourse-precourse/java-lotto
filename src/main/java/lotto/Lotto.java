package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int ticketNumbers = 6;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    /*
    public void makeLotto(){
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, ticketNumbers);
    }*/

    public List<Integer> getLotto() {
        return numbers;
    }
}
