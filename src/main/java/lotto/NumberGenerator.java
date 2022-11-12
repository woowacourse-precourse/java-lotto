package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createWinningNumbers(String inputNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splitNumbers = inputNumbers.split(",");
        for (String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public int createBonusNumbers(List<Integer> numbers, String inputNumber) {
        int bonusNumber = Integer.parseInt(inputNumber);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
