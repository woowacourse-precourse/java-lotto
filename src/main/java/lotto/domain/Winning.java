package lotto.domain;

import java.util.*;

import static lotto.messages.ERR_MSG.*;

public class Winning {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private final Set<Integer> duplicateInspector = new HashSet<>();

    public void setWinningNumbers(String winningNumbersInput) {
        validateWinningNumbers(winningNumbersInput);
        List<Integer> winningNumbers = transformToList(winningNumbersInput);
        validateHasDuplicatedNumber(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(String bonusNumberInput) {
        validateBonusNumber(bonusNumberInput);
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public List<Integer> getWinning() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }



    private List<Integer> transformToList(String winningNumbersInput) {
        String[] split = winningNumbersInput.split(",");
        List<Integer> list = new ArrayList<>();
        Arrays.stream(split).mapToInt(Integer::parseInt).forEach(list::add);
        return list;
    }

    private void validateWinningNumbers(String winningNumbersInput) {
        String unit = "[1-9]|[1-3][0-9]|[4][0-5]"; //1~45
        String format = String.format("%s,%s,%s,%s,%s,%s", unit, unit, unit, unit, unit, unit);
        if (!winningNumbersInput.matches(format)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER.getMsg());
        }
    }

    private void validateHasDuplicatedNumber(List<Integer> winningNumbers) {
        duplicateInspector.addAll(winningNumbers);
        if (duplicateInspector.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_UNIQUE.getMsg());
        }
    }

    private void validateBonusNumber(String bonusNumberInput) {
        String unit = "[1-9]|[1-3][0-9]|[4][0-5]"; //1~45
        if (!bonusNumberInput.matches(unit)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMsg());
        }
        if (duplicateInspector.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_UNIQUE.getMsg());
        }
    }
}
