package lotto;

import java.util.*;

import static lotto.Utility.printMessage;

abstract public class Exception extends Throwable {

    public static final String error = "[ERROR]";
    public static final String checkNumericError = " 숫자 형식이 아닙니다.";
    public static final String checkDivisibleError = " 1000으로 나누어 떨어지는 숫자가 아닙니다.";
    public static final String checkWinningNumbersNumericError = " 로또 리스트로 입력한 값 중 숫자 형식이 아닌 것이 있습니다.";
    public static final String checkWinningNumbersSizeError = " 로또의 숫자의 개수(6개)와 맞지 않습니다.";
    public static final String checkDistinctNumbersError = " 숫자 리스트 중 중복되는 숫자가 있습니다.";
    public static final String checkNumberRangeError = " 로또의 숫자 범위를 벗어났습니다.";
    public static final String checkDistinctNumberError = " 현재 로또 리스트의 숫자 중 보너스 숫자와 중복되는 숫자가 있습니다.";


    public static boolean checkNumeric(String input){
        try{
            Long.parseLong(input);
        }
        catch (NumberFormatException ex) {
            printMessage(error+checkNumericError);
            return false;
        }
        return true;
    }

    public static boolean checkDivisible(long dividend, long divisor){
        long remainder = dividend % divisor;
        if(remainder!=0) {
            printMessage(error+checkDivisibleError);
            return false;
        }
        return true;
    }

    public static boolean checkWinningNumbersNumeric(List <String> winningNumbers){
        for(int i=0; i<winningNumbers.size(); i++){
            try {
                Long.parseLong(winningNumbers.get(i));
            }catch(NumberFormatException ex){
                printMessage(error+checkWinningNumbersNumericError);
                return false;
            }
        }
        return true;
    }

    public static boolean checkWinningNumbersSize(List <Integer> winningNumbers){
        if(winningNumbers.size()!=Utility.lottoNumberSize){
            printMessage(error+checkWinningNumbersSizeError);
            return false;
        }
        return true;
    }

    public static boolean checkDistinctNumbers(List <Integer> numbers){
        List<Integer> _numbers = new ArrayList<>(numbers);
        Set<Integer> _distinctNumbers = new HashSet<>(_numbers);
        if(_distinctNumbers.size()!= _numbers.size()){
            printMessage(error+checkDistinctNumbersError);
            return false;
        }
        return true;
    }
    public static boolean checkNumberRange(int minimum, int maximum, int number){
        if (!(minimum<=number && number<=maximum)){
            printMessage(error+checkNumberRangeError);
            return false;
        }
        return true;
    }

    public static boolean checkDistinctNumber(List<Integer> numbers, int toCheckNumber){
        if(numbers.contains(toCheckNumber)){
            printMessage(error+checkDistinctNumberError);
            return false;
        }
        return true;
    }
}
