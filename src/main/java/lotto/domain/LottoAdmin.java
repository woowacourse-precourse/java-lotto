package lotto.domain;

import static lotto.domain.constant.LottoValueConstant.BONUS_NUMBER_IDX;
import static lotto.domain.constant.LottoValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.LottoValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.LottoValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.domain.constant.LottoValueConstant.ZERO;
import static lotto.exception.ExceptionHandler.ILLEGAL_RANGE;
import static lotto.exception.ExceptionHandler.ILLEGAL_VALUE;
import static lotto.exception.ExceptionHandler.INPUT_SIX_DIGITS;
import static lotto.exception.ExceptionHandler.OVERLAP_BONUS_NUMBER;
import static lotto.exception.ExceptionHandler.OVERLAP_NUMBER;
import static lotto.printer.InputPrinter.INPUT_BONUS_NUMBER;
import static lotto.printer.InputPrinter.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoAdmin {

    private Set<Integer> winningNumber;
    private List<Integer> bonusNumber;

    public void createWinningNumbers() {
        INPUT_WINNING_NUMBERS.print();

        this.winningNumber = Arrays.stream(Console.readLine().split(","))
                                   .map(this::winningNumberSafeParsing)
                                   .collect(Collectors.toSet());

        validateWinningNumbers(this.winningNumber);
    }

    private Integer winningNumberSafeParsing(String winningNumber) {
        try {
            return Integer.parseInt(winningNumber);
        } catch (NumberFormatException exception) {
            ILLEGAL_VALUE.error();
        }

        return ZERO.getValue();
    }


    private static void validateWinningNumbers(Set<Integer> winningNumbers) {
        validateRangeNumbers(winningNumbers);
        validateOverlapWinningNumbers(winningNumbers);

        if (winningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            INPUT_SIX_DIGITS.error();
        }
    }

    private static void validateRangeNumbers(Set<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MINIMUM_NUMBER.getValue() || number > LOTTO_MAXIMUM_NUMBER.getValue()) {
                ILLEGAL_RANGE.error();
            }
        }
    }

    private static void validateOverlapWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_OF_DIGITS.getValue()) {
            OVERLAP_NUMBER.error();
        }
    }

    public void createBonusNumber() {
        INPUT_BONUS_NUMBER.print();

        try {
            this.bonusNumber = Collections.singletonList(Integer.parseInt(Console.readLine()));

            validateRangeNumbers(new HashSet<>(this.bonusNumber));
            validateOverlapBonusNumberWithWinningNumbers(this.bonusNumber, this.winningNumber);

        } catch (NumberFormatException exception) {
            ILLEGAL_VALUE.error();
        }
    }

    private static void validateOverlapBonusNumberWithWinningNumbers(List<Integer> bonusNumber,
            Set<Integer> winningNumbers) {

        for (Integer winningNumber : winningNumbers) {
            if (Objects.equals(winningNumber, bonusNumber.get(BONUS_NUMBER_IDX.getValue()))) {
                OVERLAP_BONUS_NUMBER.error();
            }
        }
    }

    public Set<Integer> getWinningNumber() {
        return winningNumber;
    }

    public List<Integer> getBonusNumber() {
        return bonusNumber;
    }

}
