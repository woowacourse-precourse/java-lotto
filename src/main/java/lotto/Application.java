package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static final String ZERO_TO_NINE_AND_COMMA = "[0-9,]+";
    static final String ONE_TO_FORTYFIVE = "[1-9]{1}$|[1-3]{1}[0-9]{1}$|4{1}[0-5]{1}$";
    static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String NOT_NUMBERS_OR_COMMA_MESSAGE = "[ERROR] 숫자와 콤마 외의 다른 문자가 입력되었습니다.";
    static final String NOT_SIX_DIGITS_MESSAGE = "[ERROR] 당첨 번호는 6자리여야 합니다.";
    static final String NOT_WINNING_NUMBERS_RANGE_ONE_TO_FORTYFIVE_MESSAGE = "[ERROR] 당첨 번호는 1에서 45까지의 숫자를 입력해야 합니다.";
    static final String NOT_BONUS_NUMBER_RANGE_ONE_TO_FORTYFIVE_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자를 입력해야 합니다.";
    static final String DUPLICATED_NUMBERS_EXIST_MESSAGE ="[ERROR] 입력하신 번호 중 중복된 번호가 존재합니다.";
    static List<Integer> winningNumbers;
    static int bonusNumber;
    public enum Places{
        FIRST,SECOND,THIRD, FOURTH,FIFTH, OTHERS
    }
    public static void main(String[] args) {

        User user = new User();
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();
        user.getWinningNumbers(winningNumbers);
        user.getBonusNumbers(bonusNumber);
        user.calculate();

    }
    public static List<Integer> getWinningNumbers(){
        System.out.println(GET_WINNING_NUMBER_MESSAGE);
        String winningNumber = readLine();
        String[] splittedWinningNumbers = winningNumber.trim().split("\\s*,\\s*"); // 공백 제거 + ","로 split
        winningNumbersValidTest(winningNumber,splittedWinningNumbers);
        winningNumbersRangeValidTest(splittedWinningNumbers);
        List<Integer> winningNumbers = new ArrayList<>();

        for(int order=0;order<splittedWinningNumbers.length;order++) {
            int newNumber = Integer.parseInt(splittedWinningNumbers[order]);
            winningNumbersDuplicateValidTest(winningNumbers,newNumber);
            winningNumbers.add(newNumber);
        }
        return winningNumbers;
    }
    public static void winningNumbersValidTest(String winningNumber,String[] splittedWinningNumbers){
        if(!winningNumber.matches(ZERO_TO_NINE_AND_COMMA)) {
            System.err.println(NOT_NUMBERS_OR_COMMA_MESSAGE);
            throw new IllegalArgumentException(NOT_NUMBERS_OR_COMMA_MESSAGE);
        }
        if(splittedWinningNumbers.length != 6) {
            System.out.println(NOT_SIX_DIGITS_MESSAGE);
            throw new IllegalArgumentException(NOT_SIX_DIGITS_MESSAGE);
        }
    }
    public static void winningNumbersRangeValidTest(String[] splittedWinningNumbers){
        for(int order=0;order<splittedWinningNumbers.length;order++){
            if(!splittedWinningNumbers[order].matches(ONE_TO_FORTYFIVE)){
                System.out.println(NOT_WINNING_NUMBERS_RANGE_ONE_TO_FORTYFIVE_MESSAGE);
                throw new IllegalArgumentException(NOT_WINNING_NUMBERS_RANGE_ONE_TO_FORTYFIVE_MESSAGE);
            }
        }
    }
    public static void winningNumbersDuplicateValidTest(List<Integer> winningNumbers,int newNumber){
        if(winningNumbers.contains(newNumber)){
            System.out.println(DUPLICATED_NUMBERS_EXIST_MESSAGE);
            throw new IllegalArgumentException(DUPLICATED_NUMBERS_EXIST_MESSAGE);
        }
    }
    public static int getBonusNumber(){
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        String bonusNumber = readLine();
        bonusNumberValidTest(bonusNumber,winningNumbers);

        return Integer.parseInt(bonusNumber);
    }

    public static void bonusNumberValidTest(String bonusNumber, List<Integer> winningNumbers) {
        if ((!bonusNumber.matches(ONE_TO_FORTYFIVE))) {
            System.out.println(NOT_BONUS_NUMBER_RANGE_ONE_TO_FORTYFIVE_MESSAGE);
            throw new IllegalArgumentException(NOT_BONUS_NUMBER_RANGE_ONE_TO_FORTYFIVE_MESSAGE);
        }
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            System.out.println(NOT_BONUS_NUMBER_RANGE_ONE_TO_FORTYFIVE_MESSAGE);
            throw new IllegalArgumentException(NOT_BONUS_NUMBER_RANGE_ONE_TO_FORTYFIVE_MESSAGE);
        }
    }
}
