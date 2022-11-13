package lotto.ui;


import camp.nextstep.edu.missionutils.Console;
import lotto.utility.Exception;

public class UI {
    private final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private String input(){
        return Console.readLine();
    }

    private void output(String message){
        System.out.println(message);
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
}
