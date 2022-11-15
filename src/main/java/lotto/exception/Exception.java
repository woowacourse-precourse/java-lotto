package lotto.exception;

import lotto.option.IntegerOption;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Game.winningNumbers;
import static lotto.exception.ExceptionMessage.*;
import static lotto.option.IntegerOption.BASE_MONEY;
import static lotto.option.IntegerOption.ZERO;

public class Exception{
    private static final Character ZERO_CHAR = '0';
    private static final Integer ONE = 1;
    private static void throwException(Boolean bool,String error){
        if(bool) throw new IllegalArgumentException(error);
    }

    public static void catchBaseMoneyException(String input){
            throwException(Integer.parseInt(input)% BASE_MONEY.option!=ZERO.option,INPUT_ERROR.error);
    }
    public static void catchOutOfRangeException(Integer input){
            throwException(input< IntegerOption.MIN.option| IntegerOption.MAX.option<input,OUT_OF_RANGE_ERROR.error);
    }
    public static void catchDuplicatedException(List<Integer> input){
        Set<Integer> inputSet = new HashSet<>(input);
        throwException(inputSet.size()!=input.size(),DUPLICATED_ERROR.error);
    }
    public static void catchWrongCountNumberException(List<Integer> input){
        throwException(input.size()!= IntegerOption.COUNT.option,WRONG_COUNT_ERROR.error);
    }
    public static void catchNotNumericalInputException(String input){
        throwException(!input.matches("[0-9,',']+"),NOT_NUMBER_ERROR.error);
    }

    public static void catchZeroStartInputException(String input){
        throwException(ZERO_CHAR.equals(input.charAt(0)), ZERO_START_ERROR.error);
    }
    public static void catchNotBuyLottoException(String input){
        throwException(ONE.equals(input.length())&ZERO_CHAR.equals(input.charAt(0)), NOT_BUY_LOTTO_ERROR.error);
    }
    public static void catchBonusInWinningException(Integer input){
        throwException(winningNumbers.getNumbers().contains(input), BONUS_IN_WINNING_ERROR.error);
    }
}
