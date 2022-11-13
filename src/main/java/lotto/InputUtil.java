package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.CheckUtil.*;
import static lotto.model.GameMessage.*;

public class InputUtil {
    public int inputPurchasePrice(){
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());
        String input = Console.readLine();
        try {
            int inputPrice = checkIsString(input);
            checkIsDivedByTHOUSAND(inputPrice);
            return inputPrice;
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return inputPurchasePrice();
        }
    }

    private static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public List<Integer> inputWinningNumber(){
        String input = Console.readLine();
        return stringArrToIntList(commaSeparation(input));
    }

    public int inputBonusNumber(){
        String input = Console.readLine();
        return Integer.valueOf(input);
    }

    private String[] commaSeparation(String str){
        String[] arr = str.split(",");
        return arr;
    }

    private List<Integer> stringArrToIntList(String[] input){
        List<Integer> list = new ArrayList<>();
        for(String s:input){
            list.add(Integer.valueOf(s));
        }
        return list;
    }
}
