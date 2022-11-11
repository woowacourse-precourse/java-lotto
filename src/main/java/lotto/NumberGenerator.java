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

    public int createBonusNumbers(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
