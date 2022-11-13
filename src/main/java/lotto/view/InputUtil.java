package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.controller.CheckUtil.*;
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

    public List<Integer> inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        String input = Console.readLine();
        return stringArrToIntList(commaSeparation(input));
    }

    public int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        return Integer.valueOf(input);
    }

    private static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private String[] commaSeparation(String str){
        String[] arr = str.split(",");
        return arr;
    }

    private List<Integer> stringArrToIntList(String[] input){
        List<Integer> winning = new ArrayList<>();
        for(String s:input){
            winning.add(Integer.valueOf(s));
        }
        return winning;
    }
}
