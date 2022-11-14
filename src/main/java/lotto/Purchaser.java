package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Purchaser {
    private int purchaseSum;
    private int purchaseCount;
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 1000원 단위로 입력해 주세요.");
        return Console.readLine();
    }
    public int changeInt() {
        purchaseSum = Integer.parseInt(inputPurchaseAmount());
        return purchaseSum;
    }

    public int dividePurchaseSum() {
        purchaseSum = changeInt();
        if (purchaseCount / 1000 >= 1)
            purchaseCount = purchaseSum / 1000;
        else if (!(purchaseCount / 1000 >= 1))
            System.out.println("[ERROR] 구매 금액을 최소 1000원이상 입력해주세요.");
        else if (!(purchaseCount % 1000 == 0)) {
            System.out.println("[ERROR] 구매금액을 1000원 단위로 입력해주세요.");
        }
        return purchaseCount;
    }

    public List<Integer> inputLottoNum() {

    }

    public int inputBonusNum() {

    }
}