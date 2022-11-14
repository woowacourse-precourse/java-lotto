package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class PurchaseView implements View{

    private final static String NULL_INPUT_ERROR_MESSAGE = "[ERROR] 금액을 입력해주세요.";
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
        try{
            purchaseNumbers = Console.readLine();
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException();
        }

    }

    public String getPurchaseNumbers() {
        return purchaseNumbers;
    }
}
