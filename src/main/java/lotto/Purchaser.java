package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Purchaser {
    private int purchaseSum;
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 1000원 단위로 입력해 주세요.");
        return Console.readLine();
    }
    public int changePurchaseAmount() {
        purchaseSum = Integer.parseInt(inputPurchaseAmount());
        return purchaseSum;
    }



    public

    public List<Integer> inputLottoNum() {

    }

    public int inputBonusNum() {

    }
}