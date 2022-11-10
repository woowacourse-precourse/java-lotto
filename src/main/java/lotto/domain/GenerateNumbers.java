package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumbers {
    private int bonusNumbers;
    private List<Integer> generateNumbers = new ArrayList<>();

    public GenerateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 7);

        for (int i = 0; i < numbers.size() - 1; i++) {
            this.generateNumbers.add(numbers.get(i));
        }
        this.bonusNumbers = numbers.get(6);
    }

    public List<Integer> getGenerateNumbers() {
        return generateNumbers;
    }

    public int getBonusNumber() {
        return bonusNumbers;
    }
}
