package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoDraw {

    private int totalPrizeMoney;
    private Map<String, Integer> numberOfWins = new HashMap<>();
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoDraw() {
        this.totalPrizeMoney = 0;
        for (int rank = 1; rank <= 5; rank++) {
            numberOfWins.put(String.valueOf(rank) + "등", 0);
        }
        winningNumbers = UI.enterWinningNumber();
        validate(winningNumbers);

        bonusNumber = UI.enterBonusNumber();
        List<Integer> numbersWithBonusNumber = new ArrayList<>(winningNumbers);
        numbersWithBonusNumber.add(bonusNumber);

        validateDuplication(numbersWithBonusNumber);
        validateNumberRange(numbersWithBonusNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개입니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numbersSet = new HashSet<>(numbers);

        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1 ~ 45 범위입니다.");
            }
        }
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }

    public Map<String, Integer> getNumberOfWins() {
        return numberOfWins;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
