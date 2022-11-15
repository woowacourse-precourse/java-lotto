package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.ErrorMsg.INPUT_NUMBER_CONDITION;

public class RandomLotto {
    private final List<List<Integer>> randomNumbers;

    public RandomLotto(List<List<Integer>> randomNumbers) {
        validateRandomNumberDuplicate(randomNumbers);
        this.randomNumbers = randomNumbers;
    }

    public static List<List<Integer>> creatRandomNumber(int lottoQuantity) {
        List<Integer> randomNumber;
        List<List<Integer>> randomNumbersInMethod = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Collections.sort(randomNumber);
            System.out.println(randomNumber);
            randomNumbersInMethod.add(randomNumber);
        }
        return randomNumbersInMethod;
    }

    private void validateRandomNumberDuplicate(List<List<Integer>> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1).equals(numbers.get(i))) {
                throw new IllegalArgumentException(INPUT_NUMBER_CONDITION.getMessage());
            }
        }
    }
}
