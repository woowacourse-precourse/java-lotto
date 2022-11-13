package lotto.system.validator;

import lotto.dto.WinningInfoDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertingToWinningInfoValidator {

    public static final String INVALID_WINNING_NUMBERS_FORMAT_MESSAGE = "당첨금 입력값은 쉼표로 구분된 정수만 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_FORMAT_MESSAGE = "보너스 점수는 정수값만 입력해야 합니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "입력한 숫자가 로또 숫자의 범위에 맞지 않습니다.";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE = "입력한 보너스번호가 로또 번호와 중복되지 않아야 합니다.";

    public static void validate(WinningInfoDto target) {
        List<Integer> winningNumbers = convertStringToWinningNumbers(target.getWinningNumbers());
        validateWinningNumbers(winningNumbers);

        Integer bonus = convertStringToBonus(target.getBonus());
        validateBonus(bonus);

        isWinningNumbersContainingBonus(winningNumbers, bonus);
    }

    public static void validate(List<Integer> winningNumbers, Integer bonus) {
        validateWinningNumbers(winningNumbers);
        validateBonus(bonus);
        isWinningNumbersContainingBonus(winningNumbers, bonus);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        IntegerListToLottoValidator.validate(winningNumbers);
    }

    private static void validateBonus(Integer bonus) {
        isNumberInValidRange(bonus);
    }

    private static List<Integer> convertStringToWinningNumbers(String winning) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(winning.replace(" ", "").split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT_MESSAGE);
        }

        return winningNumbers;
    }

    private static Integer convertStringToBonus(String bonus) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonus);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT_MESSAGE);
        }

        return bonusNumber;
    }

    private static void isNumberInValidRange(Integer target) {
        if (target < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < target) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private static void isWinningNumbersContainingBonus(List<Integer> winningNumbers, Integer bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE);
        }
    }
}
