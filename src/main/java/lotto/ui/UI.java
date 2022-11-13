package lotto.ui;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.utility.Exception;

public class UI {
    private final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private String input(){
        return Console.readLine();
    }

    private void output(String message){
        System.out.println(message);
    }

    private void stringSplitWithCheckException(List<Integer> winningNumbers){
        List<String> winningNumberStrings = new ArrayList<>(Arrays.asList(input().split(",")));
        for(String numberString : winningNumberStrings){
            try{Exception.checkInputIsNum(numberString);}
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                winningNumbers.clear();
                stringSplitWithCheckException(winningNumbers);
            }
            int winningNumber = Integer.valueOf(numberString);
            try{Exception.checkWinningNumberRange(winningNumber);}
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                winningNumbers.clear();
                stringSplitWithCheckException(winningNumbers);
            }
            winningNumbers.add(winningNumber);
        }
    }
    
    public int inputPurchasePrice(){
        output(INPUT_PURCHASE_PRICE_MESSAGE);
        String priceString = input();
        try{Exception.checkInputIsNum(priceString);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchasePrice();
        }
        int price = Integer.parseInt(priceString);
        try{Exception.checkPriceCanDivide(price);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchasePrice();
        }
        return price;
    }

    public List<Integer> inputWinningNumbers(){
        output(INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumbers = new ArrayList<>(6);
        stringSplitWithCheckException(winningNumbers);
        try{Exception.checkNumberOfNumbers(winningNumbers);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
        try{Exception.checkDuplicateNumber(winningNumbers);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
        return winningNumbers;
    }

    public int inputBonusNumber(){
        output(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumberString = input();
        try{Exception.checkInputIsNum(bonusNumberString);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
        int bonusNumber = Integer.valueOf(bonusNumberString);
        try{Exception.checkWinningNumberRange(bonusNumber);}
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
        return bonusNumber;
    }
}
