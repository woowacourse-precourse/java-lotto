package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.SystemErrorMessage;
import lotto.util.SystemMessage;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinNumbers {
    private static final int MAX_VALUE = 45;
    private static final int MIN_VALUE = 1;
    private Lotto winNumbers;
    private BonusNumber bonusNumber;
    private Set<Integer> winNumbersSet = new HashSet<>();

    public WinNumbers(String winNumbers) {
        validate(winNumbers);
        this.winNumbers = new Lotto(winNumbersSet.stream().collect(Collectors.toList()));
        this.bonusNumber = inputBonusNumber();
        bonusNumberDuplicate(this.bonusNumber);
    }

    public Lotto getWinNumbers() {
        return winNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(String winNumbers) {
        for (String winNumber : winNumbers.split(",")) {
            validateOnlyNumber(winNumber);
            validateNumberInRange(winNumber);

            winNumbersSet.add(Integer.parseInt(winNumber));
        }
    }

    private void validateOnlyNumber(String winNumber) {
        final String REGEX = "^[0-9]*$";
        if (!Pattern.matches(REGEX, winNumber)) {
            throw new IllegalArgumentException(SystemErrorMessage.NUMBER_ERROR.getErrorMessage());
        }
    }

    private void validateNumberInRange(String winNumber) {
        int number = Integer.parseInt(winNumber);
        if (!(number >= MIN_VALUE && number <= MAX_VALUE)) {
            throw new IllegalArgumentException(SystemErrorMessage.NUMBER_ERROR.getErrorMessage());
        }
    }

    private BonusNumber inputBonusNumber() {
        System.out.println(SystemMessage.BONUS_NUMBER_INPUT.getContent());
        return new BonusNumber(Console.readLine());
    }
    private void bonusNumberDuplicate(BonusNumber bonusNumber) {
        if (winNumbers.getSortedNumber().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(SystemErrorMessage.BONUS_NUMBER_DUPLICATE_WIN_NUMBER.getErrorMessage());
        }
    }
}
