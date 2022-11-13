package lotto.utility;

import java.util.HashSet;
import java.util.List;

public interface Exception {
    public final int ZERO_ASCII = 48;
    public final int NINE_ASCII = 57;

    public final String INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE = "[ERROR] 입력 값이 숫자가 아닙니다.";
    public final String PRICE_CAN_NOT_DIVIDE_EXCEPTION_MESSAGE = "[ERROR] 입력 값이 1,000원 단위가 아닙니다.";
    public final String EXCEED_WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호의 범위를 초과하였습니다.";
    public final String Number_IS_NOT_SIX_EXCEPTION_MESSAGE = "[ERROR] 번호가 6개가 아닙니다.";
    public final String DUPLICATE_NUMBER_EXIST_EXCEPTION_MESSAGE = "[ERROR] : 중복된 숫자가 있습니다.";

    public static void checkInputIsNum(String input){
        for(int index = 0; index < input.length(); ++index)
            if(input.charAt(index) > NINE_ASCII || input.charAt(index) < ZERO_ASCII)
                throw new IllegalArgumentException(INPUT_IS_NOT_NUM_EXCEPTION_MESSAGE);
    }

    public static void checkPriceCanDivide(int price){
        if(price % 1000 != 0)
            throw new IllegalArgumentException(PRICE_CAN_NOT_DIVIDE_EXCEPTION_MESSAGE);
    }

    public static void checkWinningNumberRange(int number){
        if(number < 1 || number > 45)
            throw new IllegalArgumentException(EXCEED_WINNING_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }

    public static void checkNumberOfNumbers(List<Integer> numbers){
        if(numbers.size() != 6)
            throw new IllegalArgumentException(Number_IS_NOT_SIX_EXCEPTION_MESSAGE);
    }

    public static void checkDuplicateNumber(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>(12);
        for(Integer number : numbers){
            if(set.contains(number))
                throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST_EXCEPTION_MESSAGE);
            set.add(number);
        }
    }
}
