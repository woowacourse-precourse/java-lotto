package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView implements View{
    String purchaseInput;

    public void makeView(){
        purchasePrint();
        getPurchaseInput();
    }

    private void purchasePrint(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void getPurchaseInput(){
        purchaseInput = Console.readLine();
    }

}
