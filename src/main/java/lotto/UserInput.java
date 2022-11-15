package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final String ERROR_NUMBER_MESSAGE = " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String MONEY_AMOUNT_MESSAGE = " 로또는 1000원 단위로만 구매할 수 있습니다.";

    static String money(){
        return Console.readLine();
    }

    static void validateMoney(String coin){
        if(!coin.matches("[0-9]+")){
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
        if(Integer.parseInt(coin)<1000){
            throw new IllegalArgumentException(MONEY_AMOUNT_MESSAGE);
        }
        if(Integer.parseInt(coin) % 1000 != 0){
            throw new IllegalArgumentException(MONEY_AMOUNT_MESSAGE);
        }
    }

    static int coin(String money) {
        validateMoney(money);
        return Integer.parseInt(money)/1000;
    }

    static String userBonus(){
        return Console.readLine();
    }

    static void validateBonusNumber(String bonus){
        if(Integer.parseInt(bonus)<LOTTO_MIN_NUMBER || Integer.parseInt(bonus)>LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
        if(!bonus.matches("[0-9]+")){
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }
    static int lottoBonusNumber(String bonus){
        validateBonusNumber(bonus);
        return Integer.parseInt(bonus);
    }
    static List<String> userNumber(){
        String[] cutComma = Console.readLine().split(",");

        return Arrays.asList(cutComma);
    }

    static void validateNumber(List<String> number){
        for (int i=0;i<number.size();i++){
            if(!number.get(i).matches("[0-9]+")){
                throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
            }
            if(Integer.parseInt(number.get(i))<LOTTO_MIN_NUMBER || Integer.parseInt(number.get(i))>LOTTO_MAX_NUMBER){
                throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
            }
        }
    }

    static List<Integer> lottoNumber(List<String> userNumber){
        validateNumber(userNumber);
        return userNumber.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    }
}
