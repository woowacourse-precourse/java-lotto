package lotto.system.validator;

import lotto.dto.WinningInfoDto;
import lotto.vo.LottoInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertingToWinningInfoValidator {

    public static final String INVALID_WINNING_NUMBERS_FORMAT_MESSAGE = "당첨금 입력값은 쉼표로 구분된 정수만 입력해야 합니다.";
    public static final String INVALID_BONUS_NUMBER_FORMAT_MESSAGE = "보너스 점수는 정수값만 입력해야 합니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "입력한 보너스 번호가 로또 숫자의 범위에 맞지 않습니다.";
    public static final String BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE = "입력한 보너스번호가 로또 번호와 중복되지 않아야 합니다.";

    public static void validate(WinningInfoDto target) {
        isTargetConsistedOfNaturalNumbersAndCommaAndSpace(target.getWinningNumbers());
        isTargetConsistedOfNaturalNumber(target.getBonus());
    }

    public static void validate(List<Integer> winningNumbers, Integer bonus) {
        validateWinningNumbers(winningNumbers);
        validateBonus(bonus);
        isWinningNumbersContainingBonus(winningNumbers, bonus);
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        ConvertingToLottoValidator.validate(winningNumbers);
    }

    private static void validateBonus(Integer bonus) {
        isBonusInValidRange(bonus);
    }

    private static void isTargetConsistedOfNaturalNumbersAndCommaAndSpace(String winning) {
        try {
            Arrays.stream(winning
                            .replace(" ", "")
                            .split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT_MESSAGE);
        }
    }

    private static void isTargetConsistedOfNaturalNumber(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void isBonusInValidRange(Integer target) {
        if (target < LottoInfo.MIN_LOTTO_NUMBER || LottoInfo.MAX_LOTTO_NUMBER < target) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    private static void isWinningNumbersContainingBonus(List<Integer> winningNumbers, Integer bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(BONUS_DUPLICATING_WITH_WINNING_NUMBERS_MESSAGE);
        }
    }
}
