package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoInterface {
    public static int getPurchasePrice(){
        int purchasePrice = 0;
        System.out.println("구입금액을 입력해 주세요.");

        String userInput = Console.readLine();
        if(ErrorCheck.isValidPrice(userInput)){
            purchasePrice = Integer.parseInt(userInput);
        }
        return purchasePrice;
    }
}
