package lotto.model.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.utils.Utils;

public class WinningNumber {

    private static final String NUMBER_SEPARATOR = ",";
    private static final String WINNING_NUMBER_REGEX = "^[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*,[0-9]*$";
    private static final String BONUS_NUMBER_REGEX = "^[0-9]*";
    private static final String WRONG_WINNING_NUMBER_FORM = "올바르지 않은 당첨 번호 형식 입니다.";
    private static final String INVALID_WINNING_NUMBER_RANGE = "당첨 번호는 1이상 45 이어야 합니다.";
    private static final String DUPLICATED_WINNING_NUMBER = "당첨 번호는 중복되지 않아야 합니다.";
    private static final String BONUS_NUMBER_IS_NOT_NUMBER = "보너스 번호는 숫자 이어야 합니다.";
    private static final String INVALID_BONUS_NUMBER_RANGE = "보너스 번호는 1이상 45 이어야 합니다.";
    private static final String DUPLICATED_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";


    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final int FIFTH_SCORE = 3;
    private static final int FOURTH_SCORE = 4;
    private static final int THIRD_SCORE = 5;
    private static final int FIRST_SCORE = 6;
    private static final int LOTTO_NUM_SIZE = 6;

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(String winningNumber, String bonusNumber) {
        winningNumber = validateWinningNumber(winningNumber);
        List<Integer> numbers = parseWinningNumber(winningNumber);

        lotto = new Lotto(numbers);
        this.bonusNumber = validateBonusNumber(bonusNumber, numbers);
    }

    private int validateBonusNumber(String bonusNumber, List<Integer> numbers) {
        bonusNumber = Utils.deleteAllString(bonusNumber);
        if (!Pattern.matches(BONUS_NUMBER_REGEX, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_NUMBER);
        }
        int parsedBonusNumber = Integer.parseInt(bonusNumber);

        if (!isValidLottoNumberRange(parsedBonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        }
        if (isDuplicatedWithWinningNumber(parsedBonusNumber, numbers)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER);
        }
        return parsedBonusNumber;
    }

    private boolean isDuplicatedWithWinningNumber(int parsedBonusNumber, List<Integer> numbers) {
        return numbers.contains(parsedBonusNumber);
    }

    private String validateWinningNumber(String winningNumber) {
        winningNumber = Utils.deleteAllString(winningNumber);
        if (!Pattern.matches(WINNING_NUMBER_REGEX, winningNumber)) {
            throw new IllegalArgumentException(WRONG_WINNING_NUMBER_FORM);
        }
        List<Integer> numbers = parseWinningNumber(winningNumber);

        if (!isValidAllLottoNumberRange(numbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE);
        }
        if (hasDuplicatedLottoNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER);
        }
        return winningNumber;
    }

    private boolean hasDuplicatedLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isValidLottoNumberRange)
                .distinct()
                .count() != LOTTO_NUM_SIZE;

    }

    private boolean isValidAllLottoNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isValidLottoNumberRange)
                .count() == LOTTO_NUM_SIZE;
    }

    private boolean isValidLottoNumberRange(int num) {
        return num >= LOTTO_NUM_MIN && num <= LOTTO_NUM_MAX;
    }


    private List<Integer> parseWinningNumber(String winningNumber) {
        return Arrays.stream(winningNumber.split(NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Rank> collectRanks(List<Lotto> lottoCollection) {
        return lottoCollection.stream()
                .map(lotto -> computeRank(lotto))
                .collect(Collectors.toList());
    }

    private Rank computeRank(Lotto lotto) {
        int numOfMatch = this.lotto.countMatch(lotto);
        boolean isBonusMatch = lotto.contains(bonusNumber);

        return computeRank(numOfMatch, isBonusMatch);
    }

    private Rank computeRank(int numOfMatch, boolean isBonusMatch) {
        if (numOfMatch == FIFTH_SCORE) {
            return Rank.FIFTH;
        }
        if (numOfMatch == FOURTH_SCORE) {
            return Rank.FOURTH;
        }
        if (numOfMatch == THIRD_SCORE && !isBonusMatch) {
            return Rank.THIRD;
        }
        if (numOfMatch == THIRD_SCORE && isBonusMatch) {
            return Rank.SECOND;
        }
        if (numOfMatch == FIRST_SCORE) {
            return Rank.FIRST;
        }
        return Rank.NOTHING;
    }
}
