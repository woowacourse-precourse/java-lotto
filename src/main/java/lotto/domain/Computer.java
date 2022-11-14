package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.GameConstants.*;

public class Computer {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    private void validate(List<String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            Validator.validateNaturalNumber(winningNumber);
            Validator.validateLeadingZero(winningNumber);
        }
        this.winningNumbers = winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Validator.validateLength(this.winningNumbers, WINNING_NUMBER_LENGTH);
        Validator.validateRange(this.winningNumbers, WINNING_NUMBER_LENGTH);
        Validator.validateDuplication(this.winningNumbers, WINNING_NUMBER_LENGTH);
    }

    private void validate(String bonusNumber) {
        Validator.validateNaturalNumber(bonusNumber);
        Validator.validateLeadingZero(bonusNumber);

        this.bonusNumber = Integer.parseInt(bonusNumber);
        Validator.validateRange(this.bonusNumber);
    }

    public static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_LENGTH);
        return new Lotto(numbers);
    }
}
