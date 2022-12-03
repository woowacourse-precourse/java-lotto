package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount=Console.readLine();
        try{
            return Integer.parseInt(purchaseAmount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
