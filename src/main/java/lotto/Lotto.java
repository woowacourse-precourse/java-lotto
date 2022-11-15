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
        validateNotDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LENGTH_MUST_BE_SIX.getMessage());
        }
    }
    public static void validateNotDuplicate(List<Integer> numbers) {
        List<Integer> appearedNumList = new ArrayList<>();
        for (int index = 0; index < 6; index++){
            int tmpNum = numbers.get(index);
            if (appearedNumList.contains(tmpNum))
                throw new IllegalArgumentException(LENGTH_CANNOT_DUPLICATE.getMessage());
            appearedNumList.add(tmpNum);
        }
    }
    public static void validateNumberVariation(Lotto lotto) {
        List<Integer> numbers = lotto.numbers;
        validateOneTo45(numbers);
    }

    public static Lotto createLotto(){
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return lotto;
    }
    public static int countWinningLotto(Lotto winningLotto, Lotto candidate){
        int count = 0;
        for (int target : winningLotto.numbers){
            if (candidate.numbers.contains(target))
                count += 1;
        }
        return count;
    }
    public static int checkBonusNumber(int bonusNumber, Lotto candidate){
        if (candidate.numbers.contains(bonusNumber))
            return 3; // index of 5+bonus
        return 2; // index of 5
    }
}
