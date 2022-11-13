package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validate.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        Validator.validateOutOfSize(numbers);
        Validator.validateDuplicateData(numbers);
        Validator.validateOutOfBoundList(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Integer> generateRandomValue(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}