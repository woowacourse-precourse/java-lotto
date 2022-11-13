package lotto.system.validator;

import lotto.dto.WinningInfoDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningDtoToWinningInfoValidator {

    public static final String INVALID_WINNING_NUMBERS_FORMAT_MESSAGE = "당첨금 입력값은 쉼표로 구분된 정수만 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_FORMAT_MESSAGE = "보너스 점수는 정수값만 입력해야 합니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "입력한 숫자가 로또 숫자의 범위에 맞지 않습니다.";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE = "입력한 보너스번호가 로또 번호와 중복되지 않아야 합니다.";

    public static void validate(WinningInfoDto target) {
        List<Integer> winningNumbers = validateWinningNumbers(target.getWinningNumbers());
        Integer bonus = validateBonus(target.getBonus());

        isWinningNumbersContainingBonus(winningNumbers, bonus);
    }

    private static List<Integer> validateWinningNumbers(String winning) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(winning.replace(" ", "").split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT_MESSAGE);
        }

        IntegerListToLottoValidator.validate(winningNumbers);
        return winningNumbers;
    }

    private static Integer validateBonus(String bonus) {
        Integer bonusNumber;
        try {
            bonusNumber = Integer.valueOf(bonus);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT_MESSAGE);
        }

        isNumberInValidRange(bonusNumber);
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
