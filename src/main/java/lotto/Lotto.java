package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Code.ErrorCode.*;

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
//            if (tmpInputStr < 49 || tmpInputStr > 58)
//                // 1: 49, 9: 57
//                throw new IllegalArgumentException("1~9 사이의 숫자만 가능합니다.");
            if (appearedNumList.contains(tmpNum))
                throw new IllegalArgumentException(String.valueOf(LENGTH_CANNOT_DUPLICATE));
            appearedNumList.add(tmpNum);
        }
    }
    public static void validateNumberVariation(Lotto lotto) {
        List<Integer> numbers = lotto.numbers;
        for (int index = 0; index < 6; index++){
            int tmpNum = numbers.get(index);
            if (tmpNum >= 1 || tmpNum <= 45)
                throw new IllegalArgumentException(String.valueOf(NUMBER_VARIATION));
        }
    }


    public static List<Integer> createLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
