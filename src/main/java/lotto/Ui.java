package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Ui {


    public void startLotto(){

        String purchaseAmount = inputPurchaseAmount();

        int lottoCount = getLottoCount(purchaseAmount);


    }

    private String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
         return readLine();
    }

    private int getLottoCount(String input){
        int purchaseAmount = Integer.parseInt(input);
        return purchaseAmount / Money.THOUSAND.getAmount();
    }



}
