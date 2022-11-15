package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.enumeration.Exception;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<List<Integer>> createRandomNumbers(int inputMoney) {
        validate(inputMoney);
        List<List<Integer>> computerRandomNumbers = new ArrayList<>();

        for (int i = 0; i < (inputMoney/1000); i++) {
            List<Integer> numbers;
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            computerRandomNumbers.add(numbers);
        }
        return computerRandomNumbers;
    }

    public void validate(int inputMoney) {
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException(Exception.INVALID_PURCHASE.getExceptionMessage());
        }
    }
}
