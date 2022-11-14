package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersMaker {
    public List<Integer> makeWinningNumbers(String numbersWithComma) {
        List<Integer> winningNumbers = Arrays.stream(numbersWithComma.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public int makeBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public List<List<Integer>> makePurchaserNumbers(int purchaseAmount) {
        List<List<Integer>> purchaserNumbers = new ArrayList<>();
        List<Integer> oneGameNumbers;
        int gameCycle = purchaseAmount / 10;

        for (int i = 0; i < gameCycle; i++) {
            oneGameNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchaserNumbers.add(oneGameNumbers);
        }
        return purchaserNumbers;
    }


}
