package lotto;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class Application {
    final static String PriceMessage = "구입금액을 입력해 주세요."
    public static void main(String[] args) {
       int price = userInputPrice(PriceMessage);
    }

    private static int userInputPrice(String priceMessage) {
        System.out.println(priceMessage);
        try{
            int price = parseInt(Console.readLine());
            return price;
        }
        catch(Exception e){
            throw new IllegalArgumentException(("[ERROR] 구입금액은 "))
        }
    }
}
