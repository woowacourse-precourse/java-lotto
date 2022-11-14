package lotto.domain;

import static lotto.constant.LottoRule.END_NUMBER;
import static lotto.constant.LottoRule.START_NUMBER;
import static lotto.constant.WinningResult.RANK_1;
import static lotto.constant.WinningResult.RANK_2;
import static lotto.constant.WinningResult.RANK_3;
import static lotto.constant.WinningResult.RANK_4;
import static lotto.constant.WinningResult.RANK_5;
import static lotto.constant.WinningResult.RANK_NONE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.WinningResult;

public class WinningCalculator {
    private List<Integer> numbers;
    private int bonusNumber;
    private Map<Integer, WinningResult> winningTable = new HashMap<>();

    public WinningCalculator() {
        this.winningTable.put(0, RANK_NONE);
        this.winningTable.put(1, RANK_NONE);
        this.winningTable.put(2, RANK_NONE);
        this.winningTable.put(3, RANK_5);
        this.winningTable.put(4, RANK_4);
        this.winningTable.put(5, RANK_3);
        this.winningTable.put(6, RANK_1);
    }

    public void setWinningNumbers(String numbersRaw) {
        validate(numbersRaw);
        List<Integer> winningNumbers = convertStringToIntegerList(numbersRaw);
        numbers = winningNumbers;
    }

    public void setBonusNumber(String bonusNumberRaw) {
        int bonusNumberConverted = Integer.parseInt(bonusNumberRaw);
        bonusNumber = bonusNumberConverted;
    }

    public WinningResult getResultOfOneLotto(Lotto lotto) {
        int countContainNumbers = calculateCountContainNumbers(lotto);
        boolean isContainBonusNumber = checkIsContainBonusNumber(lotto);
        WinningResult winningResult = getWinningResultByCount(countContainNumbers, isContainBonusNumber);
        return winningResult;
    }

    private List<Integer> convertStringToIntegerList(String numbersRaw) {
        List<Integer> numbersConverted = Arrays.asList(numbersRaw.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbersConverted;
    }

    private int calculateCountContainNumbers(Lotto lotto) {
        List<Integer> numbersOfLotto = lotto.getNumbers();
        int count = 0;
        for (int number: numbersOfLotto) {
            if (this.numbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkIsContainBonusNumber(Lotto lotto) {
        List<Integer> numbersOfLotto = lotto.getNumbers();
        boolean isContainBonusNumber = numbersOfLotto.contains(this.bonusNumber);
        return isContainBonusNumber;
    }

    private WinningResult getWinningResultByCount(int countContainNumbers, boolean isContainBonusNumber) {
        WinningResult winningResult = this.winningTable.get(countContainNumbers);
        boolean isClass2 = (winningResult == RANK_3) && isContainBonusNumber;
        if (isClass2) {
            winningResult = RANK_2;
        }
        return winningResult;
    }

    private void validate(String numbersRaw) {
        try {
            List<Integer> numbers = convertStringToIntegerList(numbersRaw);
            validateNumbers(numbers);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 너무 큽니다.");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        checkLengthOfNumbers(numbers);
        checkRangeOfNumberInNumbers(numbers);
        checkDuplicationOfNumbers(numbers);
    }

    private void checkLengthOfNumbers(List<Integer> numbers) {
        if (numbers.size() == 6) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    private void checkRangeOfNumberInNumbers(List<Integer> numbers) {
        for (int number: numbers) {
            if (START_NUMBER <= number && number <= END_NUMBER) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 범위에 맞는 번호를 당첨 번호를 입력해주세요.");
        }
    }

    private void checkDuplicationOfNumbers(List<Integer> numbers) {
        Set<Integer> numbersDeletedDuplication = new HashSet<>(numbers);
        if (numbers.size() == numbersDeletedDuplication.size()) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되었습니다.");
    }
}
