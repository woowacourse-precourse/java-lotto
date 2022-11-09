package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int purchaseAmountInput() {
        String user_input = Console.readLine();
        int result;

        purchaseAmount_exceptionHandling(user_input);
        result = Integer.parseInt(user_input);

        return result;
    }

    private static void purchaseAmount_exceptionHandling(String user_input) {
        if (!isNumber(user_input) && !isDevidedThousand(user_input)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> winningLotteryInput() {
        String user_input = Console.readLine();
        List<Integer> lottery_num;

        lottery_num = winningLotteryNumber(user_input);
        return lottery_num;
    }

    private static List<Integer> winningLotteryNumber(String user_input) {
        List<String> token_String;
        List<Integer> token_int;

        token_String = restTokenizer(user_input);
        isNumExceptionHandling(token_String);
        token_int = tokenParseInt(token_String);
        isRangeExceptionHandling(token_int);
        isOverlapExceptionHandling(token_int);
        return token_int;
    }

    private static void isNumExceptionHandling(List<String> token_String) {
        if (tokenIsNumException(token_String)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isRangeExceptionHandling(List<Integer> token_int) {
        if (tokenRangeException(token_int)) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOverlapExceptionHandling(List<Integer> token_int){
        if(isOverlap(token_int)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverlap(List<Integer> token_int){
        Set<Integer> overlapCheck=new HashSet<>();
        for(int i=0;i<token_int.size();i++){
            overlapCheck.add(token_int.get((i)));
        }
        if(overlapCheck.size()!=token_int.size()){
            return true;
        }
        return false;
    }

    private static List<String> restTokenizer(String user_input) {
        List<String> token_Stirng = new ArrayList<>();
        String[] tokens = user_input.split(",");

        for (int i = 0; i < tokens.length; i++) {
            token_Stirng.add(tokens[i]);
        }
        return token_Stirng;
    }

    private static List<Integer> tokenParseInt(List<String> token_String) {
        List<Integer> token_int = new ArrayList<>();
        for (int i = 0; i < token_String.size(); i++) {
            token_int.add(Integer.parseInt(token_String.get(i)));
        }
        return token_int;
    }

    private static boolean tokenIsNumException(List<String> token) {
        for (int i = 0; i < token.size(); i++) {
            if (!isNumber(token.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean tokenRangeException(List<Integer> token) {
        for (int i = 0; i < token.size(); i++) {
            if (token.get(i) < '0' || token.get(i) > '9') {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(String user_input) {
        try {
            Integer.parseInt(user_input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDevidedThousand(String user_input_String) {
        int user_input_int = Integer.parseInt(user_input_String);
        if (user_input_int % 1000 != 0) {
            return false;
        }
        return true;
    }
}
