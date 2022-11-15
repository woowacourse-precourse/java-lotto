package lotto.calculation;

import lotto.exception.IllegalArgument;

import java.util.ArrayList;
import java.util.List;

public class Winning {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public Winning(List<String> winningNumbers) {
        List<Integer> parsingWinningNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbers) {
            if (!IllegalArgument.isNumber(winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.");
            }
            parsingWinningNumbers.add(Integer.parseInt(winningNumber));
        }
        validate(parsingWinningNumbers);
        this.winningNumbers = parsingWinningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자 6개를 입력하세요.");
        }
        if (!IllegalArgument.isInRange(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력 가능합니다.");
        }
        if (IllegalArgument.isRedundancy(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 중복되지 않는 숫자만 입력 가능합니다.");
        }
    }

    public void setBonusNumber(int bonusNumber) {
        if (IllegalArgument.isRedundancyWithNumbers(bonusNumber, winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 숫자만 입력 가능합니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
