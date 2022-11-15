package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MAX_VALUE_OF_WINNING_NUMBER = 45;
    private static final int MIN_VALUE_OF_WINNING_NUMBER = 1;
    private static final String SEPARATED_CHARACTER = ",";

    // TODO : 로또 구매 금액을 입력 받아 검증 후 반환한다.
    public static int isCorrectAmount(String purchaseAmount) {
        int amount = isContainCharacter(purchaseAmount);
        isDividedByTicketPrice(amount);
        return amount;
    }

    // TODO: 담청 번호 6자리를 입력받아 검증 후 리스트로 변환하여 반환한다.
    public static List<String> isCorrectWinningNumbers(String winningNumber){
        List<String> winningNumbers = isSixInputValues(splitBasedComma(winningNumber));
        isAllDifferentValues(winningNumbers);
        isRangeFromOneToFortyFive(winningNumbers);
        return winningNumbers;
    }

    // TODO: 보너스 번호 1자리를 입력받아 검증 후 반환한다.
    public static String isCorrectBonusNumber(String bonusNumber){
        isMatchFromOneToFortyFive(bonusNumber);
        isDuplicateNumberInWinningNumber(bonusNumber);
        return bonusNumber;
    }

    // TODO : 입력 값이 1,000으로 나누어 떨어지지 않는 경우 예외 처리 한다.
    static void isDividedByTicketPrice(int purchaseAmount) throws IllegalArgumentException{
        if (purchaseAmount % TICKET_PRICE != ZERO)
            throw new IllegalArgumentException("[ERROR] The unit of the purchase amount is not 1,000.");
    }

    // TODO : 입력 값에 문자가 포함되어 있는 경우 예외 처리 한다.
    static int isContainCharacter(String number) throws IllegalArgumentException{
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] Characters exist in the input value.");
        }
    }

    // TODO: 입력 값의 문자 혹은 숫자가 6개가 아닌 경우 예외 처리한다.
    private static List<String> isSixInputValues(List<String> winningNumbers) throws IllegalArgumentException{
        if (winningNumbers.size() != WINNING_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] The number of input values does not match 6.");
        return winningNumbers;
    }

    // TODO: 입력 값에 중복된 값이 존재하는 경우 예외 처리한다.
    static void isAllDifferentValues(List<String> winningNumbers) throws IllegalArgumentException{
        Set<String> WinningSet = new HashSet<>(winningNumbers);
        if (WinningSet.size() != WINNING_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] Duplicate number exists in input value.");
    }

    // TODO: 입력 값에 중복된 값이 존재하는 경우 예외 처리한다.
    static void isAllDifferentValuesNumber(List<Integer> lottoNumbers) throws IllegalArgumentException{
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        if (lottoSet.size() != WINNING_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] Duplicate number exists in input value.");
    }

    // TODO: 리스트의 모든 입력 값이 1~45 범위에 해당하는 경우 True 를 반환한다.
    private static void isRangeFromOneToFortyFive(List<String> winningNumbers) throws IllegalArgumentException{
        for(String number : winningNumbers)
            isMatchFromOneToFortyFive(number);
    }

    // TODO: 문자열을 1~45와 비교하여 일치하지 않는 경우 예외 처리한다.
    static void isMatchFromOneToFortyFive(String number) throws IllegalArgumentException{
        if ( !(MIN_VALUE_OF_WINNING_NUMBER <= isContainCharacter(number)
                && isContainCharacter(number) <= MAX_VALUE_OF_WINNING_NUMBER))
            throw new IllegalArgumentException("[ERROR] An out-of-range number or character exists in the input value.");

    }

    // TODO: 입력 값을 쉼표 기준으로 분리하여 리스트로 반환한다.
    private static List<String> splitBasedComma(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(SEPARATED_CHARACTER));
    }

    // TODO: 입력 값(보너스 번호)이 리스트(winningNumber)에 포함되어 있는 숫자일 경우 예외처리한다.
    private static void isDuplicateNumberInWinningNumber(String bonusNumber) throws IllegalArgumentException{
        if (Domain.getWinningNumbers().contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] The input value contains a number that overlaps the winning number.");
    }

}
