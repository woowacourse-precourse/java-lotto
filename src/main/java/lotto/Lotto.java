package lotto;

import lotto.view.printExcept;
import lotto.view.printResult;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static printExcept pe = new printExcept();
    public static printResult pr = new printResult();
    void Expception() {
        throw new IllegalArgumentException();
    }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            pe.printSizeExp();
            Expception();
        }
        for(int i:numbers) {
            for(int j:numbers) {
                isUnique(i, j, numbers);
            }
        }
    }

    // TODO: 추가 기능 구현
    void isUnique(int i, int j, List<Integer> numbers) {
        if(numbers.get(i).equals(numbers.get(j))){
            pe.printUniqueExp();
            Expception();
        }
    }
}
