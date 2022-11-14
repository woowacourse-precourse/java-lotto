package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<List<Integer>> randomNumbers;

    public List<List<Integer>> createRandomNumbers(int inputMoney) {

        List<List<Integer>> computerRandomNumbers = new ArrayList<>();

        for (int i = 0; i < (inputMoney/1000); i++) {
            List<Integer> randomNumbers = new ArrayList<>();
            randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            computerRandomNumbers.add(randomNumbers);
        }
        return computerRandomNumbers;
    }
}
