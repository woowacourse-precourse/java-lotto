package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InputManager {
    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해주세요.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    private static final String AMOUNT_DIVIDE_ERROR = "[ERROR] 구입 급액은 1000원 단위여야 합니다.";
    private static final String STRING_AMOUNT_ERROR = "[ERROR] 구입 급액은 숫자 외에 다른 문자가 포함되지 않아야 합니다.";
    private static final String WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호의 개수는 6개여야 합니다.";
    private static final String WINNING_DUPLICATE_ERROR = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";
    private static final String WINNING_RANGE_ERROR = "[ERROR] 당첨 번호는 1부터 45사이의 숫자여야 합니다.";
    private static final String WINNING_DELIMITER_ERROR = "[ERROR] 당첨 번호는 쉼표를 기준으로 구분해야 합니다.";
    private static final String BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 1개여야 하고 숫자 외에 다른 문자가 포함되지 않아야 합니다.";
    private static final String BONUS_DUPLICATE_ERROR = "[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.";
    private static final String BONUS_RANGE_ERROR = "[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.";


    public int getPurchasingAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        int amount;
        try {
            amount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(STRING_AMOUNT_ERROR);
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(AMOUNT_DIVIDE_ERROR);
        }

        return amount;
    }

    public List<Integer> drawWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT);
        String[] winningNumberInput;
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            winningNumberInput = Console.readLine().replaceAll(" ", "").split(",");
            for (String winningNumber : winningNumberInput) {
                winningNumbers.add(Integer.parseInt(winningNumber));
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(WINNING_DELIMITER_ERROR);
        }
        validateWinningNumbers(winningNumbers);


        return winningNumbers;
    }

    public int drawBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT);
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }

        validateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR);
        }

        Set<Integer> numbersSet = Sets.newHashSet(winningNumbers);
        if (numbersSet.size() != 6) {
            throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR);
        }
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(WINNING_RANGE_ERROR);
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_ERROR);
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_RANGE_ERROR);
        }
    }

}
