package lotto.util;

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
}
