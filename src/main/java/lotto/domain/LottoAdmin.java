package lotto.domain;

import static lotto.domain.constant.IntValueConstant.BONUS_NUMBER_IDX;
import static lotto.domain.constant.IntValueConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.IntValueConstant.LOTTO_NUMBER_OF_DIGITS;
import static lotto.exception.ExceptionHandler.ILLEGAL_RANGE;
import static lotto.exception.ExceptionHandler.ILLEGAL_VALUE;
import static lotto.exception.ExceptionHandler.INPUT_SIX_DIGITS;
import static lotto.exception.ExceptionHandler.OVERLAP_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoAdmin {

    private final Buyer buyer;
    private Set<Integer> winningNumber;
    private List<Integer> bonusNumber;
    public LottoAdmin(Buyer buyer) {
        this.buyer = buyer;
    }

    public void createWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputValues = Console.readLine();

        this.winningNumber =  Arrays.stream(inputValues.split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toSet());

        validateWinningNumbers(this.winningNumber);
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
                OVERLAP_NUMBER.error();
            }
        }
    }

}
