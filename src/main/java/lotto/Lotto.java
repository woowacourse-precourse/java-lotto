package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Code.ErrorCode.*;
import static lotto.Application.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(LENGTH_MUST_BE_SIX));
        }
    }
    public static void validateNotDuplicate(Lotto lotto) {
        List<Integer> numbers = lotto.numbers;
        List<Integer> appearedNumList = new ArrayList<>();
        for (int index = 0; index < 6; index++){
            int tmpNum = numbers.get(index);
            if (appearedNumList.contains(tmpNum))
                throw new IllegalArgumentException(String.valueOf(LENGTH_CANNOT_DUPLICATE));
            appearedNumList.add(tmpNum);
        }
    }
    public static void validateNumberVariation(Lotto lotto) {
        List<Integer> numbers = lotto.numbers;
        validateOneTo45(numbers);
    }

    public static List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
