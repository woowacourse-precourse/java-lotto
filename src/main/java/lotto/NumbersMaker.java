package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static resource.ErrorMessage.DUPLICATE_ERROR;
import static resource.ErrorMessage.OUT_OF_SIZE_ERROR;

public class NumbersMaker {
    public List<Integer> makeWinningNumbers(String numbersWithComma) {
        List<Integer> winningNumbers = Arrays.stream(numbersWithComma.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(OUT_OF_SIZE_ERROR);
        }

        Set<Integer> set = Set.copyOf(winningNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
        return winningNumbers;
    }

    public int makeBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public List<List<Integer>> makePurchaserNumbers(int purchaseAmount) {
        List<List<Integer>> purchaserNumbers = new ArrayList<>();
        List<Integer> oneGameNumbers;
        int gameCycle = purchaseAmount / 1000;

        for (int i = 0; i < gameCycle; i++) {
            oneGameNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchaserNumbers.add(oneGameNumbers);
        }
        return purchaserNumbers;
    }

}
