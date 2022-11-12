package lotto.util;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Validator {

    public static void checkUserInputMoney(String userInputMoney) {
        if(checkZeroInHead(userInputMoney)){
            throw new IllegalArgumentException();
        }
        if (checkOnlyNumber(userInputMoney)) {
            throw new IllegalArgumentException();
        }
        if (checkDivide(userInputMoney)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkZeroInHead(String userInputMoney) {
        if (userInputMoney.charAt(0) =='0'){
            return true;
        }
        return false;
    }

    private static boolean checkOnlyNumber(String userInputMoney) {
        char[] inputMoneyPiece = userInputMoney.toCharArray();
        for (int i = 0; i < userInputMoney.length(); i++) {
            if (inputMoneyPiece[i] < 48 || inputMoneyPiece[i] > 57) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDivide(String userInputMoney) {
        if(Integer.parseInt(userInputMoney)%1000 != 0){
            return true;
        }
        return false;
    }

    public static void checkWinningNumber(String winningNumber) {
        List<String> checkNumber = asList(winningNumber.split(","));
        if(checkLength(checkNumber)){
            throw new IllegalArgumentException("올바른 형식이 아닙니다.");
        }
        if(checkOnlyNumber(checkNumber)){
            throw new IllegalArgumentException("숫자가 아닌 다른값이 포함되어있습니다.");
        }
        if(checkNumberBoundary(checkNumber)){
            throw new IllegalArgumentException("유효 범위가 아닌 숫자가 포함되어있습니다.");
        }
    }

    private static boolean checkNumberBoundary(List<String> checkNumber) {
        for(String checkNumberPiece : checkNumber){
            if(Integer.parseInt(checkNumberPiece) > 45 ||
                    Integer.parseInt(checkNumberPiece) < 1){
                return true;
            }
        }
        return false;
    }

    private static boolean checkOnlyNumber(List<String> checkNumber) {
        try{
            for(String checkNumberPiece : checkNumber){
                Integer.parseInt(checkNumberPiece);
            }
        }catch (NumberFormatException exception){
            return true;
        }
        return false;
    }

    private static boolean checkLength(List<String> checkNumber) {
        if(checkNumber.size() != 6){
            return true;
        }
        return false;
    }
}
