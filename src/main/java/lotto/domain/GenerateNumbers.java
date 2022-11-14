package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumbers {

    private List<Integer> generateNumbers = new ArrayList<>();

    public GenerateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        for (int i = 0; i < numbers.size(); i++) {
            this.generateNumbers.add(numbers.get(i));
        }
    }

    public List<Integer> getGenerateNumbers() {
        return generateNumbers;
    }

}
