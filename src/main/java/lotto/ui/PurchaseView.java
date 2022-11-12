package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView implements View{
    private String purchaseNumbers;

    @Override
    public void makeView(){
        print();
        getInput();
    }

    private void print(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void getInput(){
        purchaseNumbers = Console.readLine();
    }

    public String getPurchaseNumbers() {
        return purchaseNumbers;
    }
}
