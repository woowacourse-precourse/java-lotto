package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Winning {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_OUT_OF_RANGE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final String WINNING_NOT_NUMBER_ERROR = "입력 값이 숫자가 아닙니다.";
    private static final String WINNING_NOT_IN_RANGE_ERROR = "당첨번호는 1 ~ 45 사이의 수 이어야 합니다.";
    private static final String WINNING_DUPLICATED_ERROR = "당첨번호에 중복이 있습니다.";
    private static final String BONUS_NUMBER_NOT_NUMBER_ERROR = "보너스 번호는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_OUT_OF_RANGE_ERROR = "보너스 번호는 1 ~ 45 사이의 수 이어야 합니다.";
    private static final String BONUS_NUMBER_DUPLICATED_ERROR = "보너스 번호와 당첨 번호가 중복됩니다.";

    public Winning() {
    }

    public static List<Integer> makeWinningNumberList(String userInput) {
        String[] numbers = userInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for (String num : numbers) {
            validateNumber(num);
            winningNumbers.add(Integer.parseInt(num));
        }

        validateNumbers(winningNumbers);

        return winningNumbers;
    }

    public static void prize(List<Lotto> lottoTickets, List<Integer> winningNumber, String bonusNumber) {
        validateBonusNumber(winningNumber, bonusNumber);
        List<Integer> matchList = new ArrayList<>();
        int[] prizeList = new int[5];

        countMatchList(lottoTickets, winningNumber, matchList, bonusNumber);
        savePrize(matchList, prizeList);

        OutputView.printPrize(prizeList);
    }

    private static void savePrize(List<Integer> matchList, int[] prizeList) {
        for (int count : matchList) {
            if (count == 3) {
                prizeList[0] += 1;
            }

            if (count == 4) {
                prizeList[1] += 1;
            }

            if(count == 5) {
                prizeList[2] += 1;
            }

            if(count == 10) {
                prizeList[3] += 1;
            }

            if(count == 6) {
                prizeList[4] += 1;
            }
        }
    }

    private static void countMatchList(List<Lotto> lottoTickets, List<Integer> winningNumber, List<Integer> matchList,
                                       String bonusNumber) {
        for (int i = 0; i < lottoTickets.size(); i++) {
            int matchCount;
            matchCount = winningNumberCount(lottoTickets, winningNumber, i, bonusNumber);
            matchList.add(matchCount);
        }
    }

    private static int winningNumberCount(List<Lotto> lottoTickets, List<Integer> winningNumber, int k,
                                          String bonusNumber) {
        int match = 0;

        for (int winNumber : winningNumber) {
            if (lottoTickets.get(k).getNumbers().contains(winNumber)) {
                match++;
            }
        }

        if (match == 5) {
            match = bonusNumberCount(lottoTickets, bonusNumber, k);
        }

        return match;
    }

    private static int bonusNumberCount(List<Lotto> lottoTickets, String bonusNumber, int k) {
        int num = Integer.parseInt(bonusNumber);
        boolean contains = lottoTickets.get(k).getNumbers().contains(num);

        if (contains) {
            return 10;
        }
        return 5;
    }

    private static void validateBonusNumber(List<Integer> winningNumber, String bonusNumber) {
        isValidateBonusNumber(bonusNumber);
        isValidateBonusNumberRange(bonusNumber);
        isDuplicatedBonusNumber(winningNumber, bonusNumber);
    }

    private static void validateNumbers(List<Integer> winningNumbers) {
        isDuplicatedWinningNumber(winningNumbers);
        isValidateWinningNumberSize(winningNumbers);
    }

    private static void validateNumber(String num) {
        isValidateWinningNumber(num);
        isValidateWinningNumberRange(num);
    }

    private static void isValidateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_OUT_OF_RANGE_ERROR);
        }
    }

    private static void isValidateWinningNumber(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NOT_NUMBER_ERROR);
        }
    }

    private static void isValidateWinningNumberRange(String num) {
        int result = Integer.parseInt(num);

        if (result < 1 || result > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_NOT_IN_RANGE_ERROR);
        }
    }

    private static void isDuplicatedWinningNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + WINNING_DUPLICATED_ERROR);
        }
    }

    private static void isValidateBonusNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_NOT_NUMBER_ERROR);
        }
    }

    private static void isValidateBonusNumberRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_OUT_OF_RANGE_ERROR);
        }
    }

    private static void isDuplicatedBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        boolean contains = winningNumbers.contains(number);

        if (contains) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_NUMBER_DUPLICATED_ERROR);
        }
    }
}
