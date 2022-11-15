package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoFactory {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_COUNT = 6;
    private static final String WINNING_NUMBER_SPLIT_CRITERIA = ",";

    public static List<Integer> createLottoRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT);
    }

    public static List<Integer> convertLottoWinningNumbers(String winningNumber) {
        return validateNumber(separate(winningNumber));
    }

    private static List<String> separate(String winningNumber) {
        return Arrays.asList(winningNumber.split(WINNING_NUMBER_SPLIT_CRITERIA));
    }

    private static List<Integer> validateNumber(List<String> winningNumber) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number : winningNumber) {
                numbers.add(Integer.parseInt(number));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호중 숫자가 아닌 값이 있습니다.");
        }
    }

}
