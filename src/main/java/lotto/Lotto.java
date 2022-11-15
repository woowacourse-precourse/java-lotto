package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int MAX_LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값 개수 입력");
        }
    }

    // TODO: 추가 기능 구현
    public boolean numberRightCompare(List<Integer> inputNumber) {
        return numbers.containsAll(inputNumber);
    }

    public List<Integer> getLottoNumber() {
        return numbers;
    }

    public void printLottoNumber() {
        System.out.print("[");
        for(int i = 0; i < MAX_LOTTO_NUMBER_COUNT; i++){
            if(i == (MAX_LOTTO_NUMBER_COUNT - 1)) {
                System.out.print(numbers.get(i));
                break;
            }
            System.out.print(numbers.get(i) + ", ");
        }
        System.out.print("]\n");
    }
}
