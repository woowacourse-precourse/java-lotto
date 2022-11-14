package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.GameConstants.*;

public class Computer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Computer() {
        String winningNumbers = InputView.readWinningNumbers();
        List<String> splittedWinningNumbers = Arrays.asList(winningNumbers.split(","));
        validate(splittedWinningNumbers);
        this.winningNumbers = splittedWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String bonusNumber = InputView.readBonusNumber();
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(List<String> winningNumbers) {
        List<Integer> convertedWinningNumbers = winningNumbers.stream()
                .peek(Validator::validateNaturalNumber)
                .peek(Validator::validateLeadingZero)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Validator.validateLength(convertedWinningNumbers, WINNING_NUMBERS_LENGTH);
        Validator.validateRange(convertedWinningNumbers, WINNING_NUMBERS_LENGTH);
        Validator.validateDuplication(convertedWinningNumbers, WINNING_NUMBERS_LENGTH);
    }

    private void validate(String bonusNumber) {
        Validator.validateNaturalNumber(bonusNumber);
        Validator.validateLeadingZero(bonusNumber);
        Validator.validateRange(Integer.parseInt(bonusNumber));
    }

    public static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBERS_LENGTH);
        return new Lotto(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
